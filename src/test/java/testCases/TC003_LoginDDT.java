package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.homePage;
import pageObjects.myAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

/*Data is valid  - login success - test pass  - logout
                   login failed - test fail

Data is invalid - login success - test fail  - logout
                  login failed - test pass
*/
public class TC003_LoginDDT extends BaseClass {


    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)

    public void verify_loginDDT(String email, String password, String exp) throws InterruptedException {

        System.out.println(email);
        System.out.println(password);


        logger.info("***********Starting TC003_LoginTest*************");

        try {
            //HomePage
            homePage hp = new homePage(driver);
            hp.clickMyAccount();
            hp.clickLogin();

            //LoginPage
            LoginPage lp = new LoginPage(driver);
            lp.setEmailAddress(email);
            lp.setPassword(password);
            lp.clicklLogin();

            //MyAccountPage


            myAccountPage map = new myAccountPage(driver);
            boolean targetPage = map.isMyAccountPageExists();
        /*Data is valid  - login success - test pass  - logout
                   login failed - test fail

        Data is invalid - login success - test fail  - logout
                  login failed - test pass
        */

            if (exp.equalsIgnoreCase("Valid")) {
                if (targetPage == true) {
                    map.clickLogout();
                    Assert.assertTrue(true);

                } else {
                    Assert.assertTrue(false);
                }
            }

            if (exp.equalsIgnoreCase("Invalid")) {
                if (targetPage == true) {
                    map.clickLogout();
                    Assert.assertTrue(false);

                } else {
                    Assert.assertTrue(true);
                }

            }
        } catch (Exception e) {
            Assert.fail("An exception occurred: " + e.getMessage());
        }
        Thread.sleep(2000);
        logger.info("***********Finished TC003_LoginTest*************");


    }
}
