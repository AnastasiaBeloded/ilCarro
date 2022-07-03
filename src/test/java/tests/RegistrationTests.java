package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logOut();
        }
    }

    @Test

    public void registrationSuccess(){

        int i = (int)System.currentTimeMillis()/1000%3600;

        User user = new User().setName("Mia").setLastName("Bio").setEmail("mia"+i+"@gmail.com").setPassword("Bio12345$");
        app.getHelperUser().openRegistrationForm();
        //app.getHelperUser().fillRegistrationForm("Mia","Bio","mia12@gmail.com","Bio12345$");
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().termsOfUseXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getMessage(),"Registered");
        app.getHelperUser().clickOk();



    }
}
