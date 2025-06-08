package testCases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.homePage;
import pageObjects.myAccountPage;
import testBase.BaseClass;


public class TC002_LoginTest extends BaseClass {


    @Test
    public void verify_login() {


        logger.info("***********Starting TC002_LoginTest*************");

        try {
            //HomePage
            homePage hp = new homePage(driver);
            hp.clickMyAccount();
            hp.clickLogin();

            //LoginPage
            LoginPage lp = new LoginPage(driver);
            lp.setEmailAddress(p.getProperty("email"));
            lp.setPassword(p.getProperty("password"));
            lp.clicklLogin();

            //MyAccountPage
            myAccountPage map = new myAccountPage(driver);
            boolean targetPage = map.isMyAccountPageExists();
//        Assert.assertEquals(targetPage,true, "Login Failed");
            Assert.assertTrue(targetPage);

        } catch (Exception e) {
            Assert.fail();
        }



        logger.info("***********Finished TC002_LoginTest*************");

    }


}
