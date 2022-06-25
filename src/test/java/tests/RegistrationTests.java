package tests;

import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

    @Test

    public void registrationSuccess(){
        openRegistrationForm();
        fillRegistrationForm("Mia","Bio","mia12@gmail.com","Bio12345$");
        termsOfUse();
        submitRegistration();



    }
}
