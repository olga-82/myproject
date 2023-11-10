import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

public class TableTest {
    WebDriver wd;
    @BeforeMethod
    public void init() {
        wd = new ChromeDriver();
        wd.navigate().to("https://www.w3schools.com/css/css_table.asp");
    }
        @Test
        public void testCss () {

         //   wd.findElement(By.cssSelector("#customers tr:nth-child(7) td:last-child"));
            wd.findElement(By.cssSelector("#customers tr:nth-child(8) td:last-child"));
            System.out.println(wd.findElements(By.cssSelector("#customers tr")).size());
            System.out. println(wd.findElements(By.cssSelector("#customers th")).size());
            wd.findElement (By.cssSelector("#customers tr:nth-child(3)"));
            wd.findElement (By.cssSelector("#customers td:last-child"));
        }
      @AfterMethod
        public void tearDown(){
    wd.quit();
        }
    }
