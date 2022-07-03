package manager;


import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
    public void fillRegistrationForm(User user){

        type(By.id("name"),user.getName());
        type(By.id("lastName"),user.getLastName());
        type(By.id("email"),user.getEmail());
        type(By.id("password"),user.getPassword());

    }
    public void termsOfUse(){
       // WebElement termsOfUse = wd.findElement(By.cssSelector(".ng-touched.ng-invalid"));
        //  WebElement termsOfUse = wd.findElement(By.cssSelector("label.checkbox-label.terms-label"));
        //termsOfUse.click();
        click(By.cssSelector("label[for='terms-of-use']"));

    }

    public boolean isLogged() {
        List<WebElement> list = wd.findElements(By.cssSelector("a[href^='/logout']"));
        return list.size()>0;
    }
    public void termsOfUseXY(){
        WebElement label = wd.findElement(By.cssSelector("label[for='terms-of-use']"));
        Rectangle rect = label.getRect();
        int xOffSet= rect.getWidth()/2;
        int yOffSet= rect.getHeight()/2;


        Actions actions = new Actions(wd);
        actions.moveToElement(label).release().perform();
        actions.moveByOffset(-xOffSet,-yOffSet).click().release().perform();

    }

    public void clickOk() {
        click(By.xpath("//button[text()='Ok']"));
    }
}
