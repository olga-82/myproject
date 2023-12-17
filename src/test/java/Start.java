import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Start {
    WebDriver wd;
    @BeforeTest
    public void precondition(){
        wd=new ChromeDriver();
        wd.get("https://telranedu.web.app/home");

    }
//    @Test
    public void test(){
        wd.findElement(By.tagName("a"));
        wd.findElement(By.cssSelector("a"));
        wd. findElement (By.xpath("//a"));

        wd.findElement(By.id("root"));
        wd.findElement(By.cssSelector("#root"));
        wd.findElement (By.xpath( "//*[@id='root']"));

        wd.findElement(By.className("container"));
        wd.findElement(By.cssSelector(".container"));
        wd.findElement(By.xpath("//*[@class='container']"));

        wd.findElement(By.linkText("HOME"));
        wd.findElement(By.partialLinkText("HO"));
        wd.findElement (By.xpath ("//a[text()='HOME']"));
        wd.findElement (By.xpath (  "//a[.='HOME']"));

        wd.findElement(By.cssSelector("[href='/login']"));
        wd. findElement (By.xpath ("//a[@href='/login']"));

        wd.findElement (By.cssSelector("[href*='og']"));
        wd. findElement (By.xpath( "//a[contains(@href,'og')]"));

        wd.findElement (By.cssSelector("[href^='/log']"));
        wd .findElement (By.xpath ( "//a[starts-with(@href,'/log')]"));
        wd.findElement (By.cssSelector("[href$='gin']"));

        //*[@id="__next"]/div[1]/main/form/div[1]/div[1]//input      name
        //*[@id="__next"]/div[1]/main/form/div[1]/div[2]//input    last name
        //*[@id="__next"]/div[1]/main/form/div[2]//input            email
        //*[@id="__next"]//div[3]//input                             password
         //*[@id="__next"]/div[1]/main/form/button
    }
    @AfterTest
    public void postcondition(){
     wd.quit();

    }
}
// //*[@id='name']
//*[@id='lastName']
//*[@id='email']
//*[@id='password']
//*[@id='terms-of-use']
//form/button