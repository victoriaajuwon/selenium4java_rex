import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import static org.openqa.selenium.support.locators.RelativeLocator.with;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Chapter3RelativeLocators {
    WebDriver driver;
    private By Credentials = By.className("orangehrm-login-error");
    private By SocialMediaPanel =  By.xpath("//div[@class='orangehrm-login-footer-sm']");
    private By FooterPanel = By.xpath("//div[@class='orangehrm-login-footer']");

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @Test
    public void testRelativeLocator(){
        WebElement loginForm = driver.findElement(By.xpath("//form[@class='oxd-form']"));
        WebElement credentialPanel = driver.findElement(RelativeLocator.with(Credentials).above(loginForm));
        System.out.println(credentialPanel.getText());
    }
    @Test
    public void testListOfElement(){
        List<WebElement> allSocialMedia = driver.findElements(with(SocialMediaPanel).near(FooterPanel));

        for (WebElement socialMedia : allSocialMedia){
            System.out.println(socialMedia.getTagName());
        }
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
