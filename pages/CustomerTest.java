package pages;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


@RunWith(Cucumber.class)
@CucumberOptions (features = "src/Cucumber/Features/", plugin = {"pretty","html:out"})

public class CustomerTest {
    private static WebDriver driver;

    @Before
    public void setUp() {
        //otwieram strone
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //czekaj zanim rzucisz wyjatkiem
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("https://qloapps.coderslab.pl/en/");
    }

    @Test
    public void Test() {
        //dodaje kontruktora aby sie zalogowac
        SignInPage signInPage = new SignInPage(driver);

        //podaje email do zalozenia konta
        signInPage.SignIn("jan.nowak@gmail.com");

        //Assert.assertEquals(); tutaj dodam sprawdzenie czy przeszlam na dobra strone po podaniu meila
        Assert.assertEquals("CREATE AN ACCOUNT", signInPage.getLoggedUsername());

        //czekaj zanim rzucisz wyjatkiem (bo nie mozesz znalezc elementu, bo element zniknal)
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        //podaje informacje uzytkownika aby sie zarejestrowac
        UserInfoPage userInfoPage = new UserInfoPage(driver);

        //Assert.assertEquals(); tutaj dodam sprawdzenie czy konto sie zalozylo
        Assert.assertEquals(" Your account has been created.",userInfoPage.getLoggedUsername() );
    }

    @After
    public void tearDown () {
        //zakoncz
        driver.quit();
    }
}
