package webDriverFactory;
/**
 *@author Садыков Александр
 * Класс создания драйвера для PageObject
 */
import org.openqa.selenium.WebDriver;

public class AbstractCloneWebDriver {
   protected  WebDriver driver;

    public AbstractCloneWebDriver(WebDriver driver) {

        this.driver = driver;
    }

}