package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.homePage;
import testBase.BaseClass;


public class TC001_AccountRegistrationTest extends BaseClass {


    @Test
    public void verify_account_registration() throws InterruptedException {

        homePage hp = new homePage(driver);
        hp.clickMyAccount();
        hp.clickRegister();


        AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
        regPage.setFirstName(randomeString().toUpperCase());
        regPage.setLastName(randomeString().toUpperCase());
        regPage.setEmail(randomeString() + "@gmail.com");  //randomly generated Email Address
        regPage.setTelephone(numberString());

        String password = randomAlphaNumeric();

        regPage.setPassword(password);
        regPage.setConfirmPassword(password);

        regPage.setPrivacyPolicy();
        regPage.clickContinue();

        String confmsg = regPage.getConfirmationMsg();
        Assert.assertEquals(confmsg, "Your Account Has Been Created!");

    }
}
