package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AccountsOverviewPage {
    private WebDriver driver;

    public AccountsOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    private By accountOverviewLink = By.cssSelector("#leftPanel > ul > li:nth-child(2) > a");
    private By accountNumberText = By.cssSelector("td > a[href*='activity.htm?id=']");
    private By availableAmountText = By.xpath("//td[@class='ng-binding' and contains(text(), '$')]");

    public void clickOpenAccountOverview() {
        driver.findElement(accountOverviewLink).click();
    }

    public String getNewAccountNumber() {
        List<WebElement> elements = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(accountNumberText));

        List<String> accountsNumbers = new ArrayList<>();

        for (WebElement element : elements) {
            accountsNumbers.add(element.getText());
        }

        String newAccNumber = accountsNumbers.get(accountsNumbers.size() -1);

        return newAccNumber;
    }

    public String getAvailableAmount() {
        List<WebElement> elements = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(availableAmountText));

        List<String> availableAmounts = new ArrayList<>();

        for (WebElement element : elements) {
            availableAmounts.add(element.getText());
        }

        String availableAmount = availableAmounts.get(availableAmounts.size() -1);

        return availableAmount;
    }

}
