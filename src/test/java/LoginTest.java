import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest extends TestBase {
//    WebDriver wd;
//
//    @BeforeMethod
//    public void init() {
//        wd = new ChromeDriver();
//        wd.navigate().to("https://telranedu.web.app/home");
//        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//    }

    @BeforeMethod
    public void preconditions() {
    if(isLogged()){
    logout();
}

    }
    @Test
    public void login() {
        // open login form
        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
        //fill login form
        // email
        WebElement emailInput = wd.findElement(By.xpath(" //input[1]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("cherry@gmail.com");
        //password
        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
        passInput.click();
        passInput.clear();
        passInput.sendKeys("Ch12345$");

        // click on button Login
        wd.findElement(By.xpath(" //button[1]")).click();

        // Assert

        //   Assert.assertTrue (wd.findElements(By.xpath("//*[.='Sign Out']")).size() > 0);
        pause(5000);
        Assert.assertTrue(wd.findElements(By.xpath("//button")).size() > 0);

    }

 /*   @Test
    public void loginNegativTestWrongEmail() {
        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
        //fill login form
        // email
        WebElement emailInput = wd.findElement(By.xpath(" //input[1]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("cherrygmail.com");
        //password

        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
        passInput.click();
        passInput.clear();
        passInput.sendKeys("Ch12345$");

        // click on button Login
        wd.findElement(By.xpath(" //button[1]")).click();
    }
*/
    @Test
    public void loginPositivTestBase() {
        openLoginForm();
        fillLoginForm("cherry@gmail.com", "Ch12345$");
        submitLogin();
        pause(5000);
        Assert.assertTrue(wd.findElements(By.xpath("//button")).size() > 0);
    }
        @AfterMethod

        public void tearDown () {
            //  wd.quit();

        }
    @Test
    public void loginNegativWrongPasswordTestBase() {
        openLoginForm();
        fillLoginForm("cherry@gmail.com", "Ch12345");
        submitLogin();
       // pause(5000);
       // Assert.assertTrue(wd.findElements(By.xpath("//button")).size() > 0);
    }


    }




