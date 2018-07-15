package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InstagramHomepage
{
    private WebDriver driver;

    // Page URL
    private static String homepageUrl = "https://www.instagram.com";

    // Homepage Elements
    @FindBy(name = "emailOrPhone")
        public WebElement numberEmail;
    @FindBy(name = "fullName")
        public WebElement fullName;
    @FindBy(name = "username")
        public WebElement username;
    @FindBy(name = "password")
        public WebElement password;
    @FindBy(xpath = "//button[contains(text(),'Sign up')]")
        public WebElement signup;
    @FindBy(id = "ssfErrorAlert")
        public WebElement emailError;
    @FindBy(xpath = "//a[contains(text(),'Log in')]")
        public WebElement login;
    @FindBy(xpath = "//button[contains(@class,'')]")
        public WebElement secondLogin;
    @FindBy(xpath = "//div[contains(@class,'pbgfb Di7vw')]")
        public WebElement searchbar;
    @FindBy(xpath = "//*[@id=\"react-root\"]/section/main/article/div[2]/div[1]/div/form/span/button")
        public WebElement facebookLogin;

    // Constructor
    public InstagramHomepage(WebDriver driver)
    {
        this.driver = driver;
        driver.get(homepageUrl);

        // Initialize web elements
        PageFactory.initElements(driver, this);
    }

    // Helper Methods
    public void enterText(WebElement e, String input)
    {
        e.sendKeys(input);
    }

    public boolean isPresentAndEnabled(WebElement e)
    {
        boolean isPresentAndEnabled = false;

        if (e.isDisplayed() && e.isEnabled())
        {
            isPresentAndEnabled = true;
            return isPresentAndEnabled;
        }

        return isPresentAndEnabled;
    }
}
