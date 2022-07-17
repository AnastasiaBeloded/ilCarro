package tests;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    Logger logger = LoggerFactory.getLogger(LoginTest.class);

    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logOut();
        }
    }


    @Test
    public void loginSuccess() {
        logger.info("Test stars with email: noa@gmail.com and password: Nnoa12345$");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("noa@gmail.com", "Nnoa12345$");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in");
        logger.info("Test passed");


    }

    @Test
    public void loginNegativeTestWrongEmail() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("noam@gmail.com", "Nnoa12345$");
        app.getHelperUser().submit();
    }

    @AfterMethod
    public void postCondition() {
        app.getHelperUser().clickOk();
    }

}
