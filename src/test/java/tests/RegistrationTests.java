package tests;

import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

    @Test

    public void registrationSuccess(){
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm("Mia","Bio","mia12@gmail.com","Bio12345$");
        app.getHelperUser().termsOfUse();
        app.getHelperUser().submitRegistration();



    }
}
