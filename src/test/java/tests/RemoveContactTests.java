package tests;

import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{

    @BeforeMethod(alwaysRun = true)
    public void precondition(){
        if (!app.getUser().isLogged()) {
            app.getUser().Login(User.builder()
                    .email("cherry@gmail.com")
                    .password("Ch12345$")
                    .build());
        }

    }

    @Test
    public void removeOneContactPositive(){
        int res = app.getContact().removeOneContact();
        Assert.assertEquals(-1, res);
    }

    @Test
    public void removeAllContactsPositive(){
        app.getContact().removeAllContacts();
        Assert.assertTrue(app.getContact().isNoContacts());
    }
}
