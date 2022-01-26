package webDriverFactory;
/**
 * @author Садыков Александр
 * Список браузеров если запущен с параметром -Dbrowser
 */
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;


import java.util.Properties;

public class DriverAsGetProperty {
    //private  WebDriver driver;
    private static String browser;


    public static WebDriver getBrowser() {

        Properties p = System.getProperties();
        browser = p.getProperty("browser").toUpperCase().trim();

        switch (browser){
            case "СHROME":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case "OPERA":
                WebDriverManager.operadriver().setup();
                return new OperaDriver();
            default:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
        }



}
}
