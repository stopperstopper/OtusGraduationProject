package pages;
/**
 *@author Садыков Александр
 *  Page Object страницы headless.
 *  Методы для заполнения полей
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webDriverFactory.AbstractCloneWebDriver;

public class HeadlessFirstElement extends AbstractCloneWebDriver {

    //инициализация всех элементов на странице
    public HeadlessFirstElement(WebDriver driver)  {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    // Поисковая строка
    @FindBy(id = "search_form_input_homepage")
    public WebElement searchField;

    // Кнопка поиска
    @FindBy(id = "search_button_homepage")
    public WebElement btnSearch;

    // 1 запрос в выдаче
    @FindBy(xpath = "//*[@id=\"r1-0\"]/div/h2/a[1]")
    public WebElement firstElement;

public void firstElementSearch(){
   searchField.clear();
   searchField.sendKeys("ОТУС");
   btnSearch.click();
}
}
