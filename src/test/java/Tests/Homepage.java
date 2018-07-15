package Tests;


import PageObjects.InstagramHomepage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class Homepage
{
    static WebDriver driver;
    static WebDriverWait waiter;

    // Input Data
    private String email = "seleniumtesterjay@gmail.com";
    private String name = "Selenium Tester";
    private String signupUsername = "automatedseleniumtester";
    private String signupPassword = "SeleniumTester24";

    private String loginUsername = "seleniumtesterjay";
    private String loginPassword = "SeleniumTester24";

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

        // Waiter initialization
        waiter = new WebDriverWait(driver, 20);

        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    /**
     * Test for Signup workflow.
     *
     * Passes if able to input data and receive expected error message
     */
    @Test
    public void signUp()
    {
        // Initialize page
        InstagramHomepage homepg = new InstagramHomepage(driver);

        // Enter email
        homepg.enterText(homepg.numberEmail, email);

        // Enter full name
        homepg.enterText(homepg.fullName, name);

        // Enter user name
        homepg.enterText(homepg.username, signupUsername);

        // Enter password
        homepg.enterText(homepg.password, signupPassword);

        // Click Sign up button
        homepg.signup.click();

        Assert.assertTrue(homepg.emailError.isDisplayed());
    }

    /**
     * Test for regular Login workflow
     *
     * Passes if able to input correct login data and successfully reach feed
     */
    @Test
    public void login()
    {
        // Initialize page
        InstagramHomepage homepg = new InstagramHomepage(driver);

        // Select login button
        homepg.login.click();

        // Wait for element then enter username
        waiter.until(ExpectedConditions.visibilityOf(homepg.username));
        homepg.enterText(homepg.username, loginUsername);

        // Enter password
        homepg.enterText(homepg.password, loginPassword);

        // Select login button
        homepg.secondLogin.click();

        // Asserts searchbar from feed appears
        Assert.assertTrue(homepg.isPresentAndEnabled(homepg.searchbar));
    }

    /**
     * Test for Facebook Login workflow
     *
     * Passes if able to input correct login data and successfully reach feed
     */
    @Test
    public void loginFacebook()
    {
        // Initialize page
        InstagramHomepage homepg = new InstagramHomepage(driver);

        // Select Facebook login
        homepg.facebookLogin.click();


    }

    @After
    public void Cleanup()
    {
        //Close the browser
        driver.close();
        driver.quit();
    }
}
