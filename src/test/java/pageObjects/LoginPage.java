package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage (WebDriver driver) {
        super(driver);
    }

    //Locators

    @FindBy(xpath = "//input[@name='email']" )
    WebElement txtEmailAddress;

    @FindBy(xpath = "//input[@name='password']" )
    WebElement txtPassword;

    @FindBy(xpath = "//input[@class='btn btn-primary']")
    WebElement btnLogin;

    //Action Method
    public void setEmailAddress(String email){
        txtEmailAddress.sendKeys(email);
    }

    public void setPassword(String password){
      txtPassword.sendKeys(password);
    }

    public void clicklLogin(){
        btnLogin.click();
    }
}

