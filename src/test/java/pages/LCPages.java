package pages;
/**
 *@author Садыков Александр
 *  Page Object страницы Мой профиль.
 *  Методы для заполнения полей
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.ConfProperties;


public class LCPages extends Abstract{


//инициализация всех элементов на странице
    public LCPages(WebDriver driver)  {

        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    /**
     * PObject
     */
    //Поле Имя
    @FindBy(id = "id_fname")
    public WebElement userName;

    //Поле Имя Латиницей
    @FindBy(id = "id_fname_latin")
    public WebElement userNameLatin;

    //Поле Фамилия
    @FindBy(id = "id_lname")
    public WebElement userLastName;

    //Поле Фамилия Латиницей
    @FindBy(id = "id_lname_latin")
    public WebElement userLastNameLatin;

    //Поле Имя в блоге
    @FindBy(id = "id_blog_name")
    public WebElement userNameBlog;

    //Поле Дата рождения
    @FindBy(name = "date_of_birth")
    public WebElement userDataBirth;

    //Поле Страна
    @FindBy(css = ".js-lk-cv-dependent-master > label:nth-child(1) > div:nth-child(2)")
    public WebElement userCountry;

    //Поле Город
    @FindBy(css = ".js-lk-cv-dependent-slave-city > label:nth-child(1) > div:nth-child(2)")
    public WebElement userTown;

    //Поле Уровень Английского
    @FindBy(css = ".container__row:nth-child(3) .select .input")
    public WebElement userLevelEnglish;

    //Поле Выбора способа связи
    @FindBy(css = ".input_straight-top-right.input_no-border-right.lk-cv-block__input_fake.lk-cv-block__input_select-fake.js-custom-select-presentation")
    public WebElement userAnotherMessenger;

    //Поле ввода способа связи
    @FindBy(id = "id_contact-0-value")
    public WebElement userAnotherMessengerField;

    //Кнопка Сохранить и Продолжить
    @FindBy(xpath = "//*[contains(text(), 'Сохранить и продолжить')]")
    public WebElement btnSaveContinue;

    /**
     * Очистка полей
     */
    public void clearField() {
        userName.clear();
        userNameLatin.clear();
        userLastName.clear();
        userLastNameLatin.clear();
        userNameBlog.clear();
        userDataBirth.clear();
        userAnotherMessengerField.clear();

    }


    /**
     * Метод заполнения данными
     */
    public void fillField() {
        userName.sendKeys("Александр");
        userNameLatin.sendKeys("Alexandr");
        userLastName.sendKeys("Садыков");
        userLastNameLatin.sendKeys("Sadykov");
        userNameBlog.sendKeys("Александр Садыков");
        userDataBirth.sendKeys("09.01.1979");

        //Заполняем поля выбора

        // Страна
        if (!userCountry.getText().contains("Россия")) {
            userCountry.click();
            driver.findElement(By.xpath("//*[contains(text(), 'Россия')]")).click();
        }

        //Город
        if (!userTown.getText().contains("Тюмень")) {
            userTown.click();
            driver.findElement(By.xpath("//*[contains(text(), 'Тюмень')]")).click();
        }

        //Уровень английского
        if (!userLevelEnglish.getText().contains("Средний (Intermediate)")) {
            userLevelEnglish.click();
            driver.findElement(By.xpath("//*[contains(text(), 'Средний (Intermediate)')]")).click();
        }
       //2 способ связи
        if(!userAnotherMessenger.getText().contains("Viber")) {
        userAnotherMessenger.click();
            driver.findElement(By.xpath("//*[contains(text(), 'Viber')]")).click();
            //driver.findElement(By.cssSelector(".lk-cv-block__select-scroll_service > .lk-cv-block__select-option:nth-child(6)")).click();
            driver.findElement(By.id("id_contact-0-value")).sendKeys("+123456789");

        }

    }
    //открывает страницу ЛК
    public void enterLc() throws InterruptedException {
        Thread.sleep(3000);//без него на chrome не запускается(раньше запускался) на firefox работает.
        driver.get(ConfProperties.getProperty("loginpage")+"/lk/biography/personal/");
    }
//Нажимаем кнопку Сохранить и продолжить
    public void btnSaveContinueClick() {
        btnSaveContinue.click();
    }


}
