package manager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HelperUser extends HelperBase{

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
       wd.findElement(By.cssSelector("div[class='header'] a:nth-child(6)")).click();
       // wd.findElement(By.cssSelector("a[href^='/login']")).click();
        //wd.findElement(By.xpath("//a[text()='Log in']")).click();
    }

    public void fillLoginForm(String email, String password) {
        type(By.cssSelector("#email"), email);//type(By.id("email"),email);
        type(By.cssSelector("#password"), password);//type(By.id("password"),password);
    }

    public void submitLogin() {
        wd.findElement(By.cssSelector("button[type='submit']")).click();
        click(By.cssSelector("button[type='button']"));
    }

    public void logOut() {
        click(By.cssSelector("div[class='header'] a:nth-child(5)"));

    }

//Registration?
    public void openRegistrationForm() {
        click(By.cssSelector("div[class='header'] a:nth-child(5)"));

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


    }

    public void submitRegistration(){
        wd.findElement(By.cssSelector("button[type='submit']")).click();

    }


    public boolean isLogged() {
        List<WebElement> list = wd.findElements(By.cssSelector("a[href^='/logout']"));
        return list.size()>0;
    }
}
