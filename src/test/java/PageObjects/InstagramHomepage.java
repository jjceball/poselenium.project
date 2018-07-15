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

    // Elements
    @FindBy(name = "emailOrPhone")
        public WebElement numberEmail;
    @FindBy(name = "fullName")
        public WebElement fullName;

    // Constructor
    public InstagramHomepage(WebDriver driver)
    {
        this.driver = driver;
        driver.get(homepageUrl);

        // Initialize web elements
        PageFactory.initElements(driver, this);
    }

    // Methods
    public void enterText(WebElement e, String input)
    {
        e.sendKeys(input);
    }
}
