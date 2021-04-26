import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Validation extends BaseTest
{
    //verify if the url is correct
    public void VerifyPageTitle()
    {
        String actualTitle = driver.getTitle();
        String expectedTitle = "AdColony";
        if (actualTitle.equals(expectedTitle))
        {
            System.out.println("Title test passed");
        }
        else
        {
            System.out.println("Title test failed" + expectedTitle);
        }
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    //verify login status
    public void verifyLogin()
    {
        Boolean verifyUrl = driver.getCurrentUrl().equals("https://clients.adcolony.com/home");
        try
        {
            Assert.assertTrue(verifyUrl);
            System.out.println("Login success");
        }
        catch (AssertionError e)
        {
            System.out.println("Login failed" + e.getStackTrace());
        }
    }


    //Validating the created App
    public void createdAppvalidation()
    {
            WebElement appName = driver.findElement(By.xpath("//strong[text()='AdColony Take Home Assignment - Ugur']"));
            if (appName.isDisplayed() == true)
            {
                System.out.println("Created App is validated successfully");
            }
            else
            {
                System.out.println("App validation failed");
            }


    }
    //verify if logout is success or not
    public void verifyLogout()
    {
        Boolean verifylogoutUrl = driver.getCurrentUrl().equals("https://clients.adcolony.com/login");
        try
        {
            Assert.assertTrue(verifylogoutUrl);
            System.out.println("Logout success");
        }
        catch (AssertionError e)
        {
            System.out.println("Logout failed" + e.getStackTrace());
        }
        driver.quit();
    }

}

