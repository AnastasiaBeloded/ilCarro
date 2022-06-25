package tests;

import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    @Test
    public void loginSuccess(){
        openLoginForm();
        fillLoginForm("noa@gmail.com","Nnoa12345$");
        submitLogin();
        logOut();

    }
    @Test
    public void loginNegativeTestWrongEmail(){
        openLoginForm();
        fillLoginForm("noam@gmail.com","Nnoa12345$");
        submitLogin();
    }


}
