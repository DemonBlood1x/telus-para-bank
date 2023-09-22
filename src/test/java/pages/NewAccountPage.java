package pages;

import conf.ExpectedValues;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewAccountPage {
    private WebDriver driver;

    public NewAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    private By openAccountLink = By.cssSelector("#leftPanel > ul > li:nth-child(1) > a");
    private By newAccountButton = By.cssSelector("#rightPanel > div > div > form > div > input");
    private By successMessage = By.xpath("//p[contains(text(),'Congratulations, your account is now open.')]");
    private By newAccountNumber = By.id("newAccountId");

    public void clickOpenAccountLink() {
        waitForWebElement(openAccountLink, ExpectedValues.WAIT_SECONDS).click();
    }

    /*  Create 2 new account to test    */
    public void clickNewAccountButton() {
        Actions act = new Actions(driver);
        WebElement element = waitForWebElement(newAccountButton, ExpectedValues.WAIT_SECONDS);
        act.doubleClick(element).perform();
    }

    public String createNewAccountNumber(){
        WebElement element = waitForWebElement(newAccountNumber, ExpectedValues.WAIT_SECONDS);
        return element.getText();
    }


    public boolean isAccountOpenedSuccessfully() {
        return waitForWebElement(successMessage, ExpectedValues.WAIT_SECONDS).isDisplayed();
    }

    private WebElement waitForWebElement(By byElement, int seconds){
        return new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.elementToBeClickable(byElement));
    }

}