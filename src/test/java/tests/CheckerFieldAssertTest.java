package tests;

/**
 *Автор Садыков Александр
 * Запуск Тестов
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import pages.AssertCheckerField;
import pages.LCPages;
import pages.LoginPage;
import webDriverFactory.Browsers;
import webDriverFactory.WebDriverFactory;
import webDriverFactory.driverAsGetProperty;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class CheckerFieldAssertTest  {
    public static LoginPage loginPage;
    public static LCPages LCPage;
    private static AssertCheckerField assertCheckerField;
    private static Logger logger = LogManager.getLogger(ConfProperties.class);
    private  WebDriver driver;
      AssertionError assertionError = null;
      public String browser;





    /**
     * осуществление первоначальной настройки
     */
    @Before
    public  void setup(){
//проверяем если есть браузер в параметрах запуска? такооой большоой костыль
        Properties p = System.getProperties();
        browser = p.getProperty("browser");

        if (browser == null) {
            driver = WebDriverFactory.createDriver(Browsers.CHROME);}
           else {
                driver = driverAsGetProperty.getBrowser();

        }




        //        ChromeOptions chOptions = new ChromeOptions();
        //        chOptions.addArguments("start-maximized");
        loginPage = new LoginPage(driver);
        LCPage = new LCPages(driver);
        assertCheckerField= new AssertCheckerField(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("loginpage"));
        logger.info("Драйвер запущен");
    }
    @After
    public void closeDriver(){
        if (driver!=null)
            driver.quit();

        logger.info("Драйвер закрыт");

        logger.info("-------------------Тест окончен---------------------");
    }

    @Test
    /**
     * тестовый метод для осуществления аутентификации и заполнение полей
     */
    public void fillTest() throws InterruptedException {
       //заходим в ЛК
        loginPage.allMethodLogin();
        //очищаем поля
        LCPage.clearField();
        //Заполняем поля+SaveContinue
        LCPage.fillField();
        LCPage.btnSaveContinueClick();
        logger.info("Поля заполнены");
    }

    @Test
    /**
     * Проверка введенных значений
     */
    public void assertTest() throws InterruptedException {
        //заходим в ЛК
        loginPage.allMethodLogin();
        // проверка значений

        try {
            assertCheckerField.assertFields();
        }
        catch (AssertionError aEr){
            assertionError = aEr;

        }
        finally {
            if (assertionError == null) {
                logger.info("Все значения полей = введенным данным");
            } else {
                logger.error("Ошибка при проверки полей");
                throw assertionError;
            }

        }
    }


}
