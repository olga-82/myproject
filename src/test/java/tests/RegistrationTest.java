package tests;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {
    @BeforeMethod
    public void preconditions() {
        if (app.getUser().isLogged()) {
            app.getUser().logout();
        }
    }
//    WebDriver wd;
//
//    @BeforeSuite
//    public void init() {
//        wd = new ChromeDriver();
//        wd.navigate().to("https://telranedu.web.app/home");
//        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//    }


//    @Test
//    public void registrationPositive() {
//        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
//        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
//        //fill login form
//        // email
//        WebElement emailInput = wd.findElement(By.xpath(" //input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("cherry" + i + "@gmail.com");
////password
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("Ch12345$");
//
//       // click on button Registration
//        wd.findElement(By.xpath(" //button[2]")).click();
//
//        // Assert
//
//        //   Assert.assertTrue (wd.findElements(By.xpath("//*[.='Sign Out']")).size() > 0);
//        //  Assert.assertTrue(wd.findElements(By.xpath("//button")).size() > 0);
//        pause(5000);
//        Assert.assertTrue(isElementPresent(By.xpath("//button")));
//    }
@Test
public void registrationPositive()  {
    int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user =User.builder()
                .email("cherry" + i + "@gmail.com")
                .password("Ch12345$")
                .build();
    app.getUser().Registration(user);
    app.getUser().pause(5000);
    Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));
}

    @Test
    public void registrationNegative()  {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "cherry" + i + "gmail.com";
        String password = "Ch12345";
        app.getUser(). openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser(). submitRegistration();
        Assert.assertTrue(app.getUser().isWrongFormatMessageRegistr());
        Assert.assertTrue(app.getUser().isAllertPresent());
    }
    @Test
    public void registrationNegativePassword() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user =User.builder()
                .email("cherry" + i + "@gmail.com")
                .password(" ")
                .build();
        app.getUser().Registration(user);
        Assert.assertTrue(app.getUser().isWrongFormatMessageRegistr());
        Assert.assertTrue(app.getUser().isAllertPresent());

    }

    @Test
    public void registrationNegativeEmail(){
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user =User.builder()
                .email("cherry" + i + "gmail.com")
                .password("Ch12345$")
                .build();
        app.getUser().Registration(user);
        Assert.assertTrue(app.getUser().isWrongFormatMessageRegistr());
        Assert.assertTrue(app.getUser().isAllertPresent());

    }


    @AfterMethod

    public void tearDown() {
       app.tearDown(); //  wd.quit();

    }


}
