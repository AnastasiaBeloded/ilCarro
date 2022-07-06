package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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
        Assert.assertEquals(app.getHelperUser().getMessage(),"Registered");


    }

    @Test

    public void registrationWrongPasswordFormatSize(){
        User user = new User().setName("Zoya").setLastName("Snow").setEmail("zoya@gmail.com").setPassword("Zoa");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().termsOfUseXY();
        Assert.assertTrue(app.getHelperUser().isErrorPasswordSizeDisplayed());
        Assert.assertTrue(app.getHelperUser().isErrorPasswordFormatDisplayed());
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());

    }

    @AfterMethod
    public void postCondition(){
        app.getHelperUser().clickOk();
    }
}
