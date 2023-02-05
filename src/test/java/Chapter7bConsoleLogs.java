import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v104.log.Log;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Chapter7bConsoleLogs {

    ChromeDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void viewBrowserConsoleLogs(){

        //Get The Dev Tools And Create A Session
        DevTools devTools = driver.getDevTools();
        devTools.createSession();

       // Enable A Console Logs
       devTools.send(Log.enable());

      // Add A Listener For The Console Logs
      devTools.addListener(Log.entryAdded(), logEntry -> {
          System.out.println("----------");
          System.out.println("Level: " +logEntry.getLevel());
          System.out.println("Text: " +logEntry.getText());
          System.out.println("Broken URL: " +logEntry.getUrl());
      });

     //Load The AUT
     driver.get("https://the-internet.herokuapp.com/broken_images");
    }
}
