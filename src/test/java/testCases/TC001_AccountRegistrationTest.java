package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.BasePage;
import pageObjects.homePage;

import java.security.PublicKey;
import java.time.Duration;

public class TC001_AccountRegistrationTest {

    public WebDriver driver;


    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.opencart.com.gr/");
        driver.manage().window().maximize();

    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void verify_account_registration() throws InterruptedException {

        homePage hp = new homePage(driver);
        hp.clickMyAccount();
        hp.clickRegister();

        Thread.sleep(5000);

        AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
        regPage.setFirstName("Amit");
        regPage.setLastName("Singh");
        regPage.setEmail("Abc@gmail.com");
        regPage.setTelephone("7539518524");
        regPage.setPassword("xyz123456");
        regPage.setConfirmPassword("xyz123456");
        regPage.setPrivacyPolicy();
        regPage.clickContinue();

    }

}
