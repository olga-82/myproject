package manager;

import model.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }
    public String findElement(By xpath) {
        WebElement element = wd.findElement(By.xpath("//*[.='LOGIN']"));
      return element.getText();
    }

    public void openLoginForm() {
        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
    }
    public void fillLoginForm(String email, String password) {
        type(By.xpath("//input[1]"), email);
        type(By.xpath("//input[2]"), password);
    }
    public void fillLoginForm(User user) {
        type(By.name("email"), user.getEmail());
        type(By.name("password"), user.getPassword());

    }
    public void Login(User user) {
        openLoginForm();
        fillLoginForm(user);
        submitLogin();
    }
    public void Registration(User user) {
        openLoginForm();
        fillLoginForm(user);
        submitRegistration();
    }

    public void submitRegistration() {
        click(By.xpath("//button[2]"));
    }
    public void submitLogin() {
        click(By.xpath("//button[1]"));
    }

    public void logout() {
        click(By.xpath("//*[.='Sign Out']"));
    }
    public boolean isLogged() {
        return isElementPresent(By.xpath("//*[.='Sign Out']"));
    }
        public boolean isAllertPresent() {
            Alert alert= new WebDriverWait(wd,10)
                    .until(ExpectedConditions.alertIsPresent());
            if (alert== null)
                return false;
             wd.switchTo().alert();
          //  System.out.println(alert.getText());
            alert.accept();
            return true;
        }
        public boolean isWrongFormatMessage() {
            Alert alert= new WebDriverWait(wd,10)
                    .until(ExpectedConditions.alertIsPresent());
            return alert.getText().contains("Wrong email or password");

        }
    public boolean isWrongFormatMessageRegistr() {
        Alert alert= new WebDriverWait(wd,10)
                .until(ExpectedConditions.alertIsPresent());
        return alert.getText().contains("Wrong email or password format");

    }

    }

