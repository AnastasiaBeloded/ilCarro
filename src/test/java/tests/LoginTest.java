package tests;


import manager.MyDataProvider;
import models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class LoginTest extends TestBase {
    Logger logger = LoggerFactory.getLogger(LoginTest.class);

    @BeforeMethod(alwaysRun = true)
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logOut();
        }
    }


    @Test(dataProvider = "dataLogin",dataProviderClass = MyDataProvider.class)
    public void loginSuccess(String email,String password) {

        logger.info("Test stars with email: "+email+"&password:"+password);
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("noa@gmail.com", "Nnoa12345$");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in");
        logger.info("Test passed");


    }
    @Test(dataProvider = "loginCsv",dataProviderClass = MyDataProvider.class)
    public void loginSuccess2(User user) {

        logger.info("Test stars with email:");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in");
        logger.info("Test passed");
    }

    @Test(groups = {"web"})
    public void loginSuccess3() {
        logger.info("Test stars with email:noa@gmail.com &password:Nnoa12345$");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("noa@gmail.com", "Nnoa12345$");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in");
        logger.info("Test passed");
    }


   /* @Test
    public void loginNegativeTestWrongEmail() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("noam@gmail.com", "Nnoa12345$");
        app.getHelperUser().submit();
    }*/

        @AfterMethod(alwaysRun = true)
        public void postCondition() {
            app.getHelperUser().clickOk();
        }

    }



