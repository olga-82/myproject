package tests;

import manager.HelperBase;
import manager.TestNgListeners;
import model.Contact;
import model.User;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase {
    Logger logger = LoggerFactory.getLogger(AddNewContactTests.class);

    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        User user = new User().withEmail("cherry27@mail.com")
                .withPassword("Ch12349$");
        if (!app.getContact().isLoggedContact()) {
      app.getUser().Login(user);
        }

        }

    @Test(invocationCount =3,groups ={"positive"} )
    public  void addNewContactPositive() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        Contact contact = Contact.builder()
                .name("Sara_" + i)
                .lastName("Braun")
                .phone("65840033" + i)
                .email("cher_" + i + "@gmail.com")
                .address("Tel Aviv")
                .description("friend")
                .build();
        logger.info("Phone number is : " + contact.getPhone());
        app.getContact().openContactForm();
        app.getContact().fillContactForm(contact);
        app.getContact().submitContactForm();
        app.getUser().pause(1000);
        Assert.assertTrue(app.getContact().isContactCreated(contact));


    }
@AfterMethod(alwaysRun = true)
public void postcondition(){
    app.getUser().logout();
}

}
