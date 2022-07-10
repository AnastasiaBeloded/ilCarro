package tests;
import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewCar extends TestBase{

    @BeforeMethod
    public void  preCondition(){
        if(!app.getHelperUser().isLogged()){
            app.getHelperUser().login(new User().setEmail("noa@gmail.com").setPassword("Nnoa12345$"));
        }
    }


    @Test
    public void addNewCarSuccess() {
        Random random = new Random();
        int i = random.nextInt(1000) + 1000;
        Car car = Car.builder()
                .address("Haifa, Israel")
                .make("Honda")
                .model("Civic")
                .year("2013")
                .engine("1.5")
                .fuel("Petrol")
                .gear("AT")
                .WD("AWD")
                .doors("5")
                .seats("4")
                .carClass("C")
                .fuelConsumption("6.5")
                .carRegistrationNumber("25-333" + i)
                .price("65")
                .distanceIncluded("800")
                .features("type of features")
                .about("very nice car")
                .build();
        app.car().openCarForm();
        app.car().fillCarForm(car);
        app.car().attachPhoto("C:\\Users\\allan\\Documents\\GitHub\\ilCarro\\90de9d5fee22c74aeb5c9de1f7c628e0.png");
        app.car().submit();
        Assert.assertEquals(app.car().getMessage(), "Car added");

    }
        @AfterMethod
        public void postCondition(){
            app.car().returnToHome();
        }


    }

