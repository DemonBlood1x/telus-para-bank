package tests;

import conf.ChromeBrowser;
import conf.UrlConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import pages.RegisterPage;

public class TestRegister {

    private RegisterPage registerPage;
    private WebDriver driver;

    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = ChromeBrowser.chromeDriverConnection(chromeOptions);
        registerPage = new RegisterPage(driver);
        driver.get(UrlConfig.PARA_BANK_URL);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test(description = "Test user registration")
    public void testUserRegistration() {
        registerPage.clickRegisterLink();
        registerPage.registerMethod();
        registerPage.clickRegisterButton();
    }
}