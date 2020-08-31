package pages;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStepdefs {
    private WebDriver driver;

    @Given("^an open browser$")
    public void anOpenBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qloapps.coderslab.pl/en/");
    }

    @When("^user tries to sign in$")
    public void userTriesToSignIn() {
        WebElement element = driver.findElement(By.className("hide_xs"));
        element.click();
    }

    @Then("^he gives his email address$")
    public void heGivesHisEmailAddress() {
        driver.get("https://qloapps.coderslab.pl/en/login?back=my-account");

        SignInPage signInPage = new SignInPage(driver);
        signInPage.SignIn("janek15.nowak@gmail.com");
    }

    @And("^clicks 'create an account'$")
    public void clicksCreateAnAccount() {
        driver.get("https://qloapps.coderslab.pl/en/login?back=my-account#account-creation");
    }

    @And("^gives his firstname \"([^\"]*)\", lastname \"([^\"]*)\", password \"([^\"]*)\", dateOfBirth \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void givesHisFirstnameLastnamePasswordDateOfBirth(String firstname, String lastname, String password, String dayOfBirth, String monthOfBirth, String yearOfBirth) {
        UserInfoPage userInfoPage = new UserInfoPage(driver);
        //userInfoPage.addInfo("Jan", "Nowak", "pass123", "10", "5", "1990");
        userInfoPage.addInfo(firstname, lastname, password, dayOfBirth, monthOfBirth, yearOfBirth);
    }

    @Then("^user is registered$")
    public void userIsRegistered() {
        driver.get("https://qloapps.coderslab.pl/en/my-account");

        UserInfoPage userInfoPage = new UserInfoPage(driver);
        userInfoPage.getLoggedUsername();
    }
}
