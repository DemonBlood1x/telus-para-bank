package pages;

import conf.ExpectedValues;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TransferFundsPage {

    private final WebDriver driver;

    public TransferFundsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By openTransferFundsLink = By.cssSelector("#leftPanel > ul > li:nth-child(3) > a");
    private By amount = By.id("amount");
    private By debit = By.id("fromAccountId");
    private By credit = By.id("toAccountId");
    private By transferButton = By.cssSelector("#rightPanel > div > div > form > div:nth-child(4) > input");

    private By transferCompleteText = By.cssSelector("#rightPanel > div > div > h1");


    public void clickOpenTransferFundsLink() {
        waitForWebElement(openTransferFundsLink, ExpectedValues.WAIT_SECONDS).click();
    }

    public void inputAmount(String testCaseAmount) {
        waitForWebElement(amount, ExpectedValues.WAIT_SECONDS).sendKeys(testCaseAmount);
    }

    public String selectDebitAccount(String testCaseDebitAccount) {
        Select dropDown = new Select(waitForWebElement(debit, ExpectedValues.WAIT_SECONDS));

        // Check if the option with the specified value exists
        List<WebElement> options = dropDown.getOptions();
        boolean optionFound = false;

        for (WebElement option : options) {
            if (option.getAttribute("value").equals(testCaseDebitAccount)) {
                optionFound = true;
                break;
            }
        }

        if (!optionFound) {
            throw new NoSuchElementException("Option with value " + testCaseDebitAccount + " not found in the dropdown.");
        }

        dropDown.selectByValue(testCaseDebitAccount);
        List<WebElement> selectedOptions = dropDown.getAllSelectedOptions();

        return selectedOptions.get(0).getAttribute("value");
    }

    public String selectCreditAccount(String testCaseCreditAccount) {
        Select dropDown = new Select(waitForWebElement(debit, ExpectedValues.WAIT_SECONDS));

        // Check if the option with the specified value exists
        List<WebElement> options = dropDown.getOptions();
        boolean optionFound = false;

        for (WebElement option : options) {
            if (option.getAttribute("value").equals(testCaseCreditAccount)) {
                optionFound = true;
                break;
            }
        }

        if (!optionFound) {
            throw new NoSuchElementException("Option with value " + testCaseCreditAccount + " not found in the dropdown.");
        }

        dropDown.selectByValue(testCaseCreditAccount);
        List<WebElement> selectedOptions = dropDown.getAllSelectedOptions();

        return selectedOptions.get(0).getAttribute("value");
    }

    public void clickTransferButton() {
        waitForWebElement(transferButton, ExpectedValues.WAIT_SECONDS).click();
    }

    public String isTransFerComplete() {
        WebElement titleElement = waitForWebElement(transferCompleteText, ExpectedValues.WAIT_SECONDS);
        String actualText = titleElement.getText();

        return actualText;

    }

    private WebElement waitForWebElement(By byElement, int seconds){
        return new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.visibilityOfElementLocated(byElement));
    }

}
