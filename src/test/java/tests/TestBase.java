package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {

    WebDriver wd;

    @BeforeMethod
    public void preCondition(){
        wd = new ChromeDriver();
        wd.navigate().to("https://ilcarro-1578153671498.web.app/search");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @AfterMethod
    public void tearDown(){
        wd.quit();
   }



//LoginTests
    public void openLoginForm(){
        WebElement loginTab = wd.findElement(By.cssSelector("div[class='header'] a:nth-child(6)"));
        loginTab.click();
    }

    public void fillLoginForm(String email,String password){
        type(By.cssSelector("#email"),email);
        type(By.cssSelector("#password"),password);
    }

    public void submitLogin(){
        wd.findElement(By.cssSelector("button[type='submit']")).click();
        type(By.cssSelector("button[type='button']"));
    }

    public void logOut(){
        WebElement logOutTab =wd.findElement(By.cssSelector("div[class='header'] a:nth-child(5)"));
        logOutTab.click();
    }

    public void type(By locator) {
        WebElement element = wd.findElement(locator);
        element.click();
   }

    public void type(By locator, String text) {
        if (text != null) {
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }
//RegistrationTests
    public void openRegistrationForm() {
        WebElement singUp = wd.findElement(By.cssSelector("div[class='header'] a:nth-child(5)"));
        singUp.click();
    }
    public void fillRegistrationForm(String name,String lastName,String email,String password){
        type(By.cssSelector("#name"),name);
        type(By.cssSelector("#lastName"),lastName);
        type(By.cssSelector("#email"),email);
        type(By.cssSelector("#password"),password);

    }
    public void termsOfUse(){
        WebElement termsOfUse = wd.findElement(By.cssSelector(".ng-touched.ng-invalid"));
      //  WebElement termsOfUse = wd.findElement(By.cssSelector("label.checkbox-label.terms-label"));
        termsOfUse.click();
      //  JavascriptExecutor js = new JavascriptExecutor() {
       //     @Override
       //     public Object executeScript(String script, Object... args) {
      //          return null;
    //        }

     //       @Override
     //       public Object executeAsyncScript(String script, Object... args) {
     //           return null;
    //        }
    //    };
     //   js.executeScript("input[type=checkbox]:not(:checked)+label.checkbox-label:after");



    }



    public void submitRegistration(){
        wd.findElement(By.cssSelector("button[type='submit']")).click();

    }


}
