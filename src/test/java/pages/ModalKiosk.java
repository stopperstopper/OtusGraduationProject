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
import tests.AbstractCloneWebDriver;

public class ModalKiosk extends AbstractCloneWebDriver {

    //инициализация всех элементов на странице
    public ModalKiosk(WebDriver driver)  {
        super(driver);
        PageFactory.initElements(driver, this);

    }


    // 1-я картинка
    @FindBy(css = "body > section.w3-gallery.py-5 > div > ul.portfolio-area.clearfix.p-0.m-0 > li:nth-child(1)")
    public WebElement firstPicture;

    @FindBy(css = "body > section.w3-gallery.py-5 > div > ul.portfolio-area.clearfix.p-0.m-0 > li:nth-child(1)")
    public WebElement modalWindow;



}
