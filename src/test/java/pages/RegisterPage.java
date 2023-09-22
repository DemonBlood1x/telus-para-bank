package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class RegisterPage {

    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    By registerLink = By.cssSelector("#loginPanel > p:nth-child(3) > a");
    By firstName = By.id("customer.firstName");
    By lastName = By.id("customer.lastName");
    By address = By.id("customer.address.street");
    By city = By.id("customer.address.city");
    By state = By.id("customer.address.state");
    By zipCode = By.id("customer.address.zipCode");
    By phone = By.id("customer.phoneNumber");
    By ssn = By.id("customer.ssn");

    By username = By.id("customer.username");
    By password = By.id("customer.password");
    By confirm = By.id("repeatedPassword");

    By registerButton = By.cssSelector("#customerForm > table > tbody > tr:nth-child(13) > td:nth-child(2) > input");

    public void clickRegisterLink() {
        driver.findElement(registerLink).click();
    }

    public void enterRegisterData(String data, By selector) {
        WebElement element = driver.findElement(selector);
        element.sendKeys(data);
    }

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    public void iterateDataRegister(List<By> selectors, List<String> data) {
        if (selectors.size() != data.size()) {
            throw new IllegalArgumentException("Data & quantity need to be the same");
        }

        for (int i = 0; i < selectors.size(); i++) {
            By selector = selectors.get(i);
            String value = data.get(i);

            WebElement element = driver.findElement(selector);

            element.clear();

            element.sendKeys(value);
        }
    }

    public void registerMethod() {
        RegisterPage registerPage = new RegisterPage(driver);
        List<By> selectors = new ArrayList<>();
        selectors.add(firstName);
        selectors.add(lastName);
        selectors.add(address);
        selectors.add(city);
        selectors.add(state);
        selectors.add(zipCode);
        selectors.add(phone);
        selectors.add(ssn);
        selectors.add(username);
        selectors.add(password);
        selectors.add(confirm);

        /* Magic data over here */
        List<String> data = new ArrayList<>();
        data.add("Test Efra");
        data.add("Last Name Test");
        data.add("123 Main St");
        data.add("El Salvador");
        data.add("San Salvador");
        data.add("1001");
        data.add("123456");
        data.add("4444");
        data.add("test1");
        data.add("123");
        data.add("123");

        registerPage.iterateDataRegister(selectors, data);
    }

}
