package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

   // WebDriver wd;
    EventFiringWebDriver wd;
    HelperUser user;


    HelperContact contact;
    public HelperUser getUser() {
        return user;
    }

    public HelperContact getContact() {
        return contact;
    }


    @BeforeSuite
    public void init() {
        wd = new EventFiringWebDriver(new ChromeDriver());
        user = new HelperUser(wd);
        contact=new HelperContact(wd);
        wd.register(new WdListener());
      //  wd.navigate().to("https://telranedu.web.app/home");
        user.navigateToMainPage();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.manage().window().maximize();
    }

    @AfterSuite

    public void tearDown() {
        wd.quit();

    }
}
