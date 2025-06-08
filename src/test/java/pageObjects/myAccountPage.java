package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class myAccountPage extends BasePage {
    public myAccountPage(WebDriver driver) {
        super(driver);
    }

    //Locator

    @FindBy(xpath = "//h2[text()='My Account']")
    WebElement msgHeading;


    @FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")
    WebElement lnkLogout;


    //ActionMethod

    public boolean isMyAccountPageExists() {
        try {
            return (msgHeading.isDisplayed());
        } catch (Exception e) {
            return false;
        }
    }

    public void clickLogout(){
        lnkLogout.click();
    }

}
