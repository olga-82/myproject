package tests;

import manager.ProviderData;
import manager.TestNgListeners;
import model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;

@Listeners(TestNgListeners.class)

public class LoginTest extends TestBase {
    @AfterMethod(alwaysRun = true)
    public void precondition(Method method) {
        if (flagNeedLogout) {
            app.getUser().logout();
            logger.info("flagNeedLogout = " + flagNeedLogout);
            logger.info("method info: " + method.getName());
            flagNeedLogout = false;
        }
            else if (flagReturnToMainPage){
                app.getUser().navigateToMainPage();
            logger.info("flagReturnToMainPage = " + flagReturnToMainPage);
            logger.info("method info: " + method.getName());
                flagReturnToMainPage = false;
            }
        }


    @Test(groups={"smoke", "positive"},dataProvider = "userDTOCSVLogin"
            ,dataProviderClass = ProviderData.class)
    public void login(User user) {
       app.getUser().Login(user);
       flagNeedLogout=true;
        logger.info("flagNeedLogout = " + flagNeedLogout);
        logger.info(" loginPositiveUser starts with credentials "
                + user.getEmail() + " " + user. getPassword());
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")), "Login Pass");


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



    @Test(groups={"regress", "negative"},dataProvider="userDTO_CSVregNegativPassword",dataProviderClass = ProviderData.class)
    public void loginNegativWrongPasswordTestBase(User user) {
//        User user = new User()
//                .withEmail("cherry@gmail.com")
//                .withPassword("Ch12345");

        app.getUser().Login(user);
        flagReturnToMainPage=true;
        logger.info("flagNeedLogout = " + flagNeedLogout);
        logger.info(" loginPositiveUser starts with credentials "
                + user.getEmail() + " " + user. getPassword());
        Assert.assertTrue(app.getUser().isWrongFormatMessage());
        Assert.assertTrue(app.getUser().isAllertPresent());
    }

    @Test(groups={"regress", "negative"},dataProvider="userDTO_CSVregNegativEmail",dataProviderClass = ProviderData.class)
    public void loginNegativWrongEmailTestBase(User user) {
//        User user = new User()
//                .withEmail("cherrygmail.com")
//                .withPassword("Ch12345$");

        app.getUser().Login(user);
        flagReturnToMainPage=true;
       Assert.assertTrue(app.getUser().isWrongFormatMessage());
       Assert.assertTrue(app.getUser().isAllertPresent());

    }
}



