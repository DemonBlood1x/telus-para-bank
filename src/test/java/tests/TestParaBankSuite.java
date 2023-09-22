package tests;

import actions.LoginActions;
import conf.ChromeBrowser;
import conf.ExpectedValues;
import conf.UrlConfig;
import dataproviders.DataFromJSON;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import pages.AccountsOverviewPage;
import pages.NewAccountPage;
import pages.TransferFundsPage;

public class TestParaBankSuite {

    private LoginActions loginAction;
    private NewAccountPage accountPage;
    private AccountsOverviewPage overviewPage;
    private TransferFundsPage transferFundsPage;
    private String newAccNumber = "";
    private WebDriver driver;

    @BeforeClass
    public void setupClass() {
        // Set up WebDriverManager for Chrome
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setup() {
        // Create a new WebDriver instance with Chrome options
        driver = ChromeBrowser.chromeDriverConnection(new ChromeOptions());
        loginAction = new LoginActions(driver);
        accountPage = new NewAccountPage(driver);
        overviewPage = new AccountsOverviewPage(driver);
        transferFundsPage = new TransferFundsPage(driver);
        driver.get(UrlConfig.PARA_BANK_URL);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Description("Test 1: Open A New Account")
    @Test(priority = 1)
    public void testLoginAndWelcomeMessage() {
        String welcomeMessage = loginAction.loginAction();
        Assert.assertTrue(welcomeMessage.contains(ExpectedValues.WELCOME));

        accountPage.clickOpenAccountLink();
        accountPage.clickNewAccountButton();
        newAccNumber = accountPage.createNewAccountNumber();
        Assert.assertTrue(accountPage.isAccountOpenedSuccessfully());

        overviewPage.clickOpenAccountOverview();
        String accountNumberFromOverview = overviewPage.getNewAccountNumber();
        String availableAmount = overviewPage.getAvailableAmount();

        // Make sure the new account number matches the one created
        Assert.assertEquals(accountNumberFromOverview, newAccNumber);
        // Add an assertion for available amount if ExpectedValues.AMOUNT is provided
        Assert.assertEquals(availableAmount, ExpectedValues.AMOUNT);
    }

    @Description("Test 2: Transfer Funds")
    @Test(dataProvider = ExpectedValues.PROVIDER,
            dataProviderClass = DataFromJSON.class,
            priority = 2)
    public void testNewAccountNumber(String testCaseNumber, String testCaseAmount, String testCaseDebitAccount, String testCaseCreditAccount) {
        loginAction.loginAction();
        transferFundsPage.clickOpenTransferFundsLink();
        transferFundsPage.selectDebitAccount(testCaseDebitAccount);
        transferFundsPage.selectCreditAccount(testCaseCreditAccount);
        transferFundsPage.inputAmount(testCaseAmount);

        transferFundsPage.clickTransferButton();

        String actualText = transferFundsPage.isTransFerComplete();

        // Use Assert to verify if the actual text matches the expected text
        Assert.assertEquals(actualText, ExpectedValues.EXPECTED_TEXT);

    }
}
