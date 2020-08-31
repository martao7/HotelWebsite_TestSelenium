package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    private static WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "email_create")
    private WebElement emailInput;

    @FindBy(name = "SubmitCreate")
    private WebElement submitButton;

    @FindBy(className = "page-heading")
    private WebElement createAccount;


    public void SignIn(String email) {
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);

        submitButton.click();
    }

    public String getLoggedUsername() {
        return createAccount.getText();
    }
}
