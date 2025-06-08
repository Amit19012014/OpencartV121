package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage extends BasePage {

    public homePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement lnkMyaccount;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement lnkRegister;

    @FindBy(xpath = "//a[contains(text(),'Login')]")
    WebElement linkLogin;


    public void clickMyAccount() {
        lnkMyaccount.click();
    }

    public void clickRegister() {
        lnkRegister.click();
    }

    public void clickLogin() {
        linkLogin.click();
    }

}
