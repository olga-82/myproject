package tests;

import manager.TestNgListeners;
import model.Contact;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase {
    Logger logger = LoggerFactory.getLogger(AddNewContactTests.class);

    @BeforeMethod
    public void precondition() {
        if (!app.getUser().isLogged()) {
            app.getUser().Login(User.builder()
                    .email("cherry@gmail.com")
                    .password("Ch12345$")
                    .build());
        }

    }
    @Test(invocationCount = 5)
    public void addNewContactPositive(){
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        Contact contact =  Contact.builder()
                .name("Sara_" + i)
                .lastName("Braun")
                .phone("65840033"+i)
                .email("cher_"+i+"@gmail.com")
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
}
