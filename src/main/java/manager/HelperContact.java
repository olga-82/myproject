package manager;

import model.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class HelperContact extends HelperBase {

    Logger logger= LoggerFactory.getLogger(HelperContact.class);
    public HelperContact(WebDriver wd) {
        super(wd);
    }

    public void openContactForm() {
        wd.findElement(By.xpath("//*[.='ADD']")).click();
    }

    public void fillContactForm(Contact contact) {
        type(By.xpath("//input[@placeholder='Name']"), contact.getName());
        type(By.xpath("//input[@placeholder='Last Name']"), contact.getLastName());
        type(By.xpath("//input[@placeholder='Phone']"), contact.getPhone());
        type(By.xpath("//input[@placeholder='email']"), contact.getEmail());
        type(By.xpath("//input[@placeholder='Address']"), contact.getAddress());
        type(By.xpath("//input[@placeholder='description']"), contact.getDescription());

    }

    public void submitContactForm() {
        click(By.xpath("//button[.='Save']"));
    }

    public boolean isContactCreated(Contact contact) {
        String phone = wd.findElement(By.xpath("//div[@class='contact-item_card__2SOIM'][last()]//h3")).getText();
        return phone.equals(contact.getPhone());

    }
    public int countContacts(){
        return wd.findElements(By.xpath("//div[@class='contact-item_card__2SOIM']")).size();
    }
    public int removeOneContact(){
        int countBefore = countContacts();
        logger.info("Amount of contacts before is " + countBefore);
        click(By.xpath("//div[@class='contact-item_card__2SOIM']"));
        click(By.xpath("//button[.='Remove']"));
        pause(5000);
        int countAfter = countContacts();
        logger.info("Amount of contacts after is " + countAfter);
        return countAfter - countBefore;
    }

    public void removeAllContacts(){
        while (wd.findElements(By.xpath("//div[@class='contact-item_card__2SOIM']")).size() > 0){
            removeOneContact();
        }
    }

    public boolean isNoContacts(){
        return wd.findElements(By.xpath("//div[@class='contact-item_card__2SOIM']")).size()==0;
    }






//
//    public void setSize() {
//    List<WebElement> listInputs = wd.findElements(By.xpath("//*[@id='root']/div[2]/div/div/div[1]/div/div"));
//    System.out.println("length of list  " + listInputs.size());
//
//    WebElement parentOfInput =  wd.findElement(By.xpath("//*[@id='root']/div[2]/div/div/div[1]/div/div"));
//    System.out.println("print attribute name " + parentOfInput.getText().toString());
//
//}


    public void clickBoxWithContact() {
        wd.findElement(By.xpath("//div[@class='contact-item_card__2SOIM'][1]")).click();

    }
    public boolean isBoxPresent(){
      return isElementPresent(By.xpath("//*[@id='root']/div[2]/div/div/div[2]/div"));
    }


    public void clickButtonRemove() {
        wd.findElement(By.xpath("//button[.='Remove']")).click();

    }
    //*[@id="root"]/div[2]/div/div/div[1]/div/div[1]/h2

    //button[.='Remove']
}



