package tests;

import model.Contact;
import model.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{

    @BeforeMethod(alwaysRun = true)
    public void precondition(){
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User().withEmail("cherry@gmail.com")
                .withPassword("Ch12345$");
        if (!app.getUser().isLogged()) {
            app.getUser().Login(user);

        }
        app.getContact().openContactForm();
        app.getContact().fillContactForm(Contact.builder()
                .name("Sara_" + i)
                .lastName("Braun")
                .phone("65840033" + i)
                .email("cher_" + i + "@gmail.com")
                .address("Tel Aviv")
                .description("friend")
                .build());
        app.getContact().submitContactForm();
    }

    @Test(groups = {"positive", "smoke"})
    public void removeOneContactPositive(){
        int res = app.getContact().removeOneContact();
        Assert.assertEquals(-1, res);
    }

    @Test
    public void removeAllContactsPositive(){
        app.getContact().removeAllContacts();
        Assert.assertTrue(app.getContact().isNoContacts());
    }
    @AfterMethod(alwaysRun = true)
    public void postcondition(){
        app.getUser().logout();
    }
}
