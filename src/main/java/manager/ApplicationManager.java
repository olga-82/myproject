package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.safari.SafariDriver;
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

    String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public HelperUser getUser() {
        return user;
    }

    public HelperContact getContact() {
        return contact;
    }

    @BeforeSuite(alwaysRun = true)
    public void init() {
        if(browser.equals(BrowserType.CHROME)) {
            wd = new EventFiringWebDriver(new ChromeDriver());
            logger.info("Test start on Chrome");
        }else if(browser.equals(BrowserType.FIREFOX)){
            wd = new EventFiringWebDriver(new FirefoxDriver());
            logger.info("Test start on FireFox");
        } else if (browser.equals(BrowserType.SAFARI)) {
            wd=new EventFiringWebDriver(new SafariDriver());
            logger.info("Test start on Safari");


        }
        user = new HelperUser(wd);
        contact=new HelperContact(wd);
        wd.register(new WdListener());
      //  wd.navigate().to("https://telranedu.web.app/home");
        user.navigateToMainPage();
        wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wd.manage().window().maximize();
    }

    @AfterSuite(alwaysRun = true)

    public void tearDown() {
        wd.quit();

    }
}
