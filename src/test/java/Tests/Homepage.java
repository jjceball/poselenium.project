package Tests;


import PageObjects.InstagramHomepage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class Homepage
{
    static WebDriver driver;

    @Before
    public void TestSetup()
    {
        // Tells the System where the Chrome Driver is
        System.setProperty("webdriver.chrome.driver", "/Users/jayceballos/Documents/Development/chromedriver");

        // Chrome Options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--test-type");

        // Initialize chrome browser
        driver = new ChromeDriver(options);

        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void signUp()
    {
        // Input Data
        String email = "jjceball@gmail.com";
        String name = "Jay Jacob Ceballos";

        // Initialize page
        InstagramHomepage homepg = new InstagramHomepage(driver);

        // Enter email
        homepg.enterText(homepg.numberEmail, email);

        // Enter full name
        homepg.enterText(homepg.fullName, name);

        Assert.assertEquals(email, (homepg.numberEmail.getAttribute("value")));
    }

    @After
    public void Cleanup()
    {
        //Close the browser
        driver.close();
        driver.quit();
    }
}
