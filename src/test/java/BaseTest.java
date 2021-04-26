import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseTest
{
    public static WebDriver driver = null;
    //Login with the given credentials
    public void login()
    {
        WebElement userName = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.xpath("//button[contains(@class,'btn btn-primary')]"));
        userName.sendKeys("adc_interview@email.com");
        password.sendKeys("@dc-1nterview");
        loginBtn.click();
    }

//Navigate to apps pane
    public void navigateToapps()
    {
        try
        {
            WebElement moneizationbtn =(driver.findElement(By.xpath("//a[@href='/apps']")));
            Actions c1 = new Actions(driver);
            c1.click(moneizationbtn).perform();
            WebElement appsBtn =driver.findElement(By.xpath("//a[@class='sub-nav__link active']"));
            appsBtn.click();
        }
        catch (NoSuchElementException e)
        {
            System.out.println("Element is not visible"+ e.getStackTrace() );
        }

    }
    //Start customizing the app
    public void customizeApp()
    {

        WebElement setupNewAppbtn = driver.findElement(By.xpath("//a[@href='/app/new']"));
        setupNewAppbtn.click();
       WebElement appName = driver.findElement(By.id("name"));
       appName.sendKeys("AdColony Take Home Assignment - Ugur");
       Select platform = new Select(driver.findElement(By.xpath("(//select[@class='custom-select'])[2]")));
       platform.selectByIndex(1);
        JavascriptExecutor je = (JavascriptExecutor) driver;
        WebElement deselectBtn = driver.findElement(By.xpath("(//button[contains(@class,'btn btn-secondary')])[2]"));
        je.executeScript("arguments[0].scrollIntoView(true);",deselectBtn);
        deselectBtn.click();
        System.out.println("All ad types removed");
    }
    //Select ad Types
    public void selectAdTypes()
    {

        WebElement gamblingChckBox = driver.findElement(By.xpath("(//input[@id='filters'])[3]"));
        WebElement apps17ChckBox = driver.findElement(By.xpath("//label[text()[normalize-space()='Apps (13-16)']]/following::input"));
        WebElement foodChckBox = driver.findElement(By.xpath("//label[text()[normalize-space()='Affiliate Offers']]/following::input"));
        WebElement internetChckBox = driver.findElement(By.xpath("//label[text()[normalize-space()='Retail']]/following::input"));
        WebElement healthChckBox = driver.findElement(By.xpath("//label[text()[normalize-space()='Lottery']]/following::input"));
        gamblingChckBox.click();
        apps17ChckBox.click();
        foodChckBox.click();
        internetChckBox.click();
        healthChckBox.click();
        System.out.println("Ad types selected");
    }
    //Press the Create button and complete App creation
    public void createApp()
    {
        try
        {
            WebElement createBtn = driver.findElement(By.xpath("//button[contains(@class,'btn btn-primary')]"));
            createBtn.click();
            Thread.sleep(5000);
            System.out.println("App created Successfully");

        }
        catch (NoSuchElementException e)
        {
            System.out.println("Create button not present"+e.getStackTrace());

        }
        catch (InterruptedException e)
        {
            System.out.println(e.getStackTrace());
        }
    }
    //Logout from the portal
    public void logOut()
    {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        WebElement settingsBtn = driver.findElement(By.xpath("//strong[contains(@class,'center fa')]"));
        WebElement logoutBtn = driver.findElement(By.xpath("(//a[@class='dropdown-item'])[2]"));
        je.executeScript("arguments[0].scrollIntoView(true);",settingsBtn);
        settingsBtn.click();
        logoutBtn.click();

    }

}
