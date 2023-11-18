package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {


    @BeforeMethod
    public void preconditions() {
        if (app.getUser().isLogged()) {
            app.getUser().logout();
        }

    }

    @Test
    public void login() {
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm("cherry@gmail.com", "Ch12345$");
        app.getUser().submitLogin();
      //  app.getUser().pause(5000);
       Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")), "Login Pass");;
        app.getUser().logout();

    }
//        // open login form
//        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
//        //fill login form
//        // email
//        WebElement emailInput = wd.findElement(By.xpath(" //input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("cherry@gmail.com");
//        //password
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("Ch12345$");
//
//        // click on button Login
//        wd.findElement(By.xpath(" //button[1]")).click();
//
//        // Assert
//
//           Assert.assertTrue (wd.findElements(By.xpath("//*[.='Sign Out']")).size() > 0);
//        pause(5000);
//        Assert.assertTrue(wd.findElements(By.xpath("//button")).size() > 0);
//
//    }

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
    public void loginNegativWrongPasswordTestBase() {

        app.getUser().openLoginForm();
        app.getUser().fillLoginForm("cherry@gmail.com", "Ch12345");
        app.getUser().submitLogin();
       // Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//*[.='LOGIN']")));

    }

    @Test
    public void loginNegativWrongEmailTestBase() {
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm("cherrygmail.com", "Ch12345");
        app.getUser().submitLogin();
       // Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//*[.='LOGIN']")));

    }
}



