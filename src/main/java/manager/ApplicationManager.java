package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class ApplicationManager {

    WebDriver wd;
    HelperUser helperUser;
    HelperCar car;
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    public void init(){

        wd = new ChromeDriver();
        logger.info("All tests run in chrome browser");
        wd.navigate().to("https://ilcarro-1578153671498.web.app/search");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        logger.info("Current Url---->"+wd.getCurrentUrl());

        car = new HelperCar(wd);

        helperUser = new HelperUser(wd);
    }


    public void stop(){
        wd.quit();
    }

    public HelperUser getHelperUser() {
        return helperUser;
    }



    public HelperCar car() {
        return car;
    }
}
