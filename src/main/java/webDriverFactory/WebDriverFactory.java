package webDriverFactory;
/**
 * @author Садыков Александр
 * WebDriverFactory without(with) options
 */


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class WebDriverFactory {

    public static WebDriver createDriver(Browsers type){
        switch (type){
            case CHROME:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case OPERA:
                WebDriverManager.operadriver().setup();
                return new OperaDriver();
            case IE:
                WebDriverManager.operadriver().setup();
                return new InternetExplorerDriver();
            case EDGE:
                WebDriverManager.operadriver().setup();
                return new EdgeDriver();
            default:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
        }
    }

    public static WebDriver createDriver(Browsers type, MutableCapabilities webDriverOptions){
        switch (type){
            case CHROME:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver( (ChromeOptions) webDriverOptions);
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver((FirefoxOptions) webDriverOptions);
            case OPERA:
                WebDriverManager.operadriver().setup();
                return new OperaDriver((OperaOptions) webDriverOptions);
            case IE:
                WebDriverManager.iedriver().setup();
                return new InternetExplorerDriver((InternetExplorerOptions) webDriverOptions);
            case EDGE:
                WebDriverManager.operadriver().setup();
                return new EdgeDriver((EdgeOptions) webDriverOptions);
                default:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver( (ChromeOptions) webDriverOptions);
        }
    }


}
