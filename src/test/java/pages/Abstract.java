package pages;
/**
 *Автор Садыков Александр
 * Класс создания драйвера для PageObject
 */
import org.openqa.selenium.WebDriver;

public class Abstract {
   protected  WebDriver driver;

    public Abstract(WebDriver driver) {

        this.driver = driver;
    }

}