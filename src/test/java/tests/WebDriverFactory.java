package tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    public static WebDriver getDriver(String browserType){
        WebDriver driver = null;

        switch (browserType.toLowerCase()){
            case "chrome" :
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
        }
        return driver;
    }

    public static String getFile(String fileName) {
        String filePath = null;
        ClassLoader classLoader = WebDriverFactory.class.getClassLoader();
        try {
            filePath= classLoader.getResource(fileName).getPath();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  "file://"+filePath;
    }
}
