package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;
    HelperUser user;

    public HelperUser getUser() {
        return user;
    }

    @BeforeSuite
    public void init() {
        wd = new ChromeDriver();
        user = new HelperUser(wd);
        wd.navigate().to("https://telranedu.web.app/home");
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.manage().window().maximize();
    }

    @AfterSuite

    public void tearDown() {
        wd.quit();

    }
}
