package actions;

import conf.ExpectedValues;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginActions {

    LoginPage elements;

    public LoginActions(WebDriver driver) {
        this.elements = new LoginPage(driver);
    }

    public String loginAction() {
        elements.enterUsername(ExpectedValues.USER);
        elements.enterPassword(ExpectedValues.PASS);
        elements.clickLoginButton();
        return elements.getWelcomeMessage();
    }
}
