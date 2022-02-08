package tests;

/**
 *@author  Садыков Александр
 * Запуск Тестов
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.AuthOtus;
import pages.HeadlessFirstElement;
import pages.ModalKiosk;
import webDriverFactory.Browsers;
import webDriverFactory.WebDriverFactory;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class OtusGraduationProject {

    private static Logger logger = LogManager.getLogger(OtusGraduationProject.class);
    private WebDriver driver;
    public static AuthOtus loginPage;
    public static ModalKiosk modalKiosk;
    public static HeadlessFirstElement headlessFirstElement;


    @Before
    public  void setup(){
           logger.info("-------------------Новый тест----------------------");
      }

    @After
    public void closeDriver() {
        if (driver != null)
            driver.quit();

        logger.info("Драйвер закрыт");

        logger.info("-------------------Тест окончен---------------------");
    }

    @Test
    /**
     * Тест открыть chrome в headless и сравнить 1-й элемент с текстом
     */
    public  void chromeHeadless() throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = WebDriverFactory.createDriver(Browsers.CHROME, options);
        driver.get("https://duckduckgo.com/");
        headlessFirstElement = new HeadlessFirstElement(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
       //ищем 1 элемент
        headlessFirstElement.firstElementSearch();
        //Сравниваем значение
        Assert.assertEquals("Онлайн‑курсы для профессионалов, дистанционное обучение...", headlessFirstElement.firstElement.getText());
        logger.info("Headless");
    }

    @Test
    /**
     * Тест открыть chrome в режиме киоска и проверить открытие картинки в модальном окне
     */
    public  void chromeKiosk() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--kiosk");
        driver = WebDriverFactory.createDriver(Browsers.CHROME, options);
        driver.get("https://demo.w3layouts.com/demos_new/template_demo/03-10-2020/photoflash-liberty-demo_Free/685659620/web/index.html?_ga=2.181802926.889871791.1632394818-2083132868.1632394818");
              modalKiosk = new ModalKiosk(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //клик на 1 картинке
        modalKiosk.firstPicture.click();
       //проверяем открылось ли модальное окно
        Assert.assertTrue(modalKiosk.modalWindow.isEnabled());
        logger.info("Модальное окно");

   }
    @Test
    /**
     * Тест аутентификация в ОТУС
     */
    public void loginPageOtus() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = WebDriverFactory.createDriver(Browsers.CHROME, options);

        driver.get("https://otus.ru");
        loginPage = new AuthOtus(driver);
        // Вход в ЛК
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        loginPage.allMethodLogin();
        logger.info("Аутентификация в OTUS");
       Set<Cookie> allcookies = driver.manage().getCookies();
        logger.info("Cookies "+allcookies);
    }

}


