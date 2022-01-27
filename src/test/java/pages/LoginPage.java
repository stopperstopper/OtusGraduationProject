package pages;
/**
 *@author Садыков Александр
 *  Page Object страницы Авторизации.
 *  Методы для заполнения полей
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.ConfProperties;

import static tests.CheckerFieldAssertTest.LCPage;
import static tests.CheckerFieldAssertTest.loginPage;


public class LoginPage extends Abstract {

//инициализация всех элементов на странице
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
       // this.driver = driver;
    }


    // Кнопка входа
    @FindBy(css = "button.header2__auth.js-open-modal")
    public WebElement btnAuth;

    //Поле логина
    @FindBy(css = "div.new-input-line_slim:nth-child(3) > input:nth-child(1)")
    public WebElement loginField;

    //Поле пароля
    @FindBy(css = ".js-psw-input")
    public WebElement passwdField;

    //Кнопка войти
    @FindBy(xpath = "(//button[@type='submit'])[3]")
    public WebElement btnEnterLC;

    // Метод для авторизации
    public void clickBtnAuth() {
        btnAuth.click();
    }

    // Метод ввода логина
    public void inputLogin(String login) {
        loginField.clear();
        loginField.sendKeys(login);
    }

    // Метод ввода пароля
    public void inputPasswd(String passwd) {
        passwdField.clear();
        passwdField.sendKeys(passwd);
    }

    // Метод нажатия кнопки входа в ЛК
    public void clickBtnEnterLC() {
        btnEnterLC.click();
    }
    //Общий метод входа в ЛК
   public void allMethodLogin() throws InterruptedException {
       // Вход в ЛК
       loginPage.clickBtnAuth();
       //вводим пароль
       loginPage.inputLogin(ConfProperties.getProperty("login"));
       loginPage.inputPasswd(ConfProperties.getProperty("password"));
       //нажимаем кнопку входа
       loginPage.clickBtnEnterLC();
    // Вход в ЛК
       LCPage.enterLc();
   }
}
