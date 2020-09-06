package pages2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class AddAddressPage {
    private static WebDriver driver;

    public AddAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //address     |   postal code   |  city   |  country   |  home phone   | mobile phone

    @FindBy(id = "address1")
    private WebElement addressInput;

    @FindBy(id = "postcode")
    private WebElement postalCodeInput;

    @FindBy(name = "city")
    private WebElement cityInput;

    @FindBy(id = "id_country")
    private WebElement countryInput;

    @FindBy(id = "phone")
    private WebElement homePhoneInput;

    @FindBy(id = "phone_mobile")
    private WebElement handyInput;

    @FindBy(id = "alias")
    private WebElement aliasCheck;

    @FindBy (id = "submitAddress")
    private WebElement submitAddressButton;

    @FindBy (id = "user_info_acc")
    private WebElement yourAccountText;


    public void addAddress(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5) {

        addressInput.click();
        addressInput.clear();
        addressInput.sendKeys(arg0);

        postalCodeInput.click();
        postalCodeInput.clear();
        postalCodeInput.sendKeys(arg1);

        cityInput.click();
        cityInput.clear();
        cityInput.sendKeys(arg2);

        Select countryInputSelect = new Select(countryInput);
        countryInputSelect.selectByVisibleText(arg3);
        countryInput.click();

        homePhoneInput.click();
        homePhoneInput.clear();
        homePhoneInput.sendKeys(arg4);

        handyInput.click();
        handyInput.clear();
        handyInput.sendKeys(arg5);

        aliasCheck.click();
        aliasCheck.clear();
        aliasCheck.sendKeys("jan4.nowak@gmail.com");

    }

    public void saveButton() {

        try {
            submitAddressButton.click();;
        } catch (Exception exception) {
            cityInput.click();
            cityInput.clear();
            addressInput.sendKeys("wro");
        }
    }

    public String getLoggedUsername() {
        return yourAccountText.getText();
    }
}

