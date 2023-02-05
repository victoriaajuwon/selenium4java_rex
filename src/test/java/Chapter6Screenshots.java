import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Chapter6Screenshots {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://applitools.com/");
    }

    @Test
    public void testWebElementScreenshot() throws IOException {
        WebElement nextGenerationPlatform = driver.findElement(By.cssSelector("#post-8 h1"));
        File source = nextGenerationPlatform.getScreenshotAs(OutputType.FILE);
        File destination = new File("Next Generation Platform.png");
        FileHandler.copy(source,destination);
    }

    @Test
    public void testPageSectionScreenshot() throws IOException {
        WebElement applitoolsPageSection = driver.findElement(By.cssSelector("#post-8>header"));
        File source = applitoolsPageSection.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("Applitools Page Section.png"));
    }

    /*
    @Test
    public void testFullPageScreenshot() throws IOException {   //Ability to take full page screenshot can only be done with firefox driver
        File source = ((FirefoxDriver)driver).getFullPageScreenshotAs(OutputType.FILE);
        FileHandler.copy(source, new File("Applitools Full Page Screenshot.png"));
    }

     */
}
