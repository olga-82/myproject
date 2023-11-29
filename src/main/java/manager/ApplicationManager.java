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

    public HelperUser getUser() {
        return user;
    }

    @BeforeSuite
    public void init() {
        wd = new EventFiringWebDriver(new ChromeDriver());
        user = new HelperUser(wd);
        wd.register(new WdListener());
        wd.navigate().to("https://telranedu.web.app/home");
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.manage().window().maximize();
    }

    @AfterSuite

    public void tearDown() {
      //  wd.quit();

    }
}
