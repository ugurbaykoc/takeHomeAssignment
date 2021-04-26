import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class TestMethods extends BaseTest
{
    //Run the tests
    @Before
    public void Setup()
    {
        System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://clients.adcolony.com");
    }

    @Test
    public void completeAdCreation()
    {
        BaseTest b1 = new BaseTest();
        Validation v1 = new Validation();
        v1.VerifyPageTitle();
        b1.login();
        v1.verifyLogin();
        b1.navigateToapps();
        b1.customizeApp();
        b1.selectAdTypes();
        b1.createApp();
        b1.logOut();
        v1.verifyLogout();
    }

    @Test
    public void validateCreatedApp()
    {
        BaseTest b2 = new BaseTest();
        Validation v2 = new Validation();
        b2.login();
        v2.verifyLogin();
        b2.navigateToapps();
        v2.createdAppvalidation();
        b2.logOut();
        v2.verifyLogout();

    }
}
