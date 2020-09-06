package pages2;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class MyStepdefs2 {
    private WebDriver driver;

    @Given("^click to 'add my first address'$")
    public void clickToAddMyFirstAddress() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qloapps.coderslab.pl/en/my-account");

        SignInAgainPage signInAgainPage = new SignInAgainPage(driver);
        signInAgainPage.SignIn("jan4.nowak@gmail.com", "pass123");

        WebElement addFirstAddressButton = driver.findElement(By.className("icon-building"));
        addFirstAddressButton.click();

        driver.get("https://qloapps.coderslab.pl/en/address");
    }

    @When("^he gives his \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void heGivesHis(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
        AddAddressPage addAddressPage = new AddAddressPage(driver);
        addAddressPage.addAddress(arg0, arg1, arg2, arg3, arg4, arg5);

    }

    @And("^clicks button save$")
    public void clicksButtonSave() {
        AddAddressPage addAddressPage = new AddAddressPage(driver);
        addAddressPage.saveButton();
    }

    @Then("^address is successfully added$")
    public void addressIsSuccessfullyAdded() {
        AddAddressPage addAddressPage = new AddAddressPage(driver);
        Assert.assertEquals("Janek", addAddressPage.getLoggedUsername());
    }
}
