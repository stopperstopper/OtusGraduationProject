package pages;

/**
 *Автор Садыков Александр
 *  Методы для проверки полей
 */

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;



public class AssertCheckerField extends LCPages {
    //инициализация всех элементов на странице
    public AssertCheckerField(WebDriver driver) {
      super(driver);
      PageFactory.initElements(driver, this);
      this.driver = driver;}


    public void assertFields() {
        Assert.assertEquals("Александр",userName.getAttribute("value"));
        Assert.assertEquals("Alexandr", userNameLatin.getAttribute("value"));
        Assert.assertEquals("Садыков", userLastName.getAttribute("value"));
        Assert.assertEquals("Sadykov", userLastNameLatin.getAttribute("value"));
        Assert.assertEquals("09.01.1979", userDataBirth.getAttribute("value"));
        Assert.assertEquals("Россия", userCountry.getText());
        Assert.assertEquals("Тюмень", userTown.getText());
        Assert.assertEquals("Средний (Intermediate)", userLevelEnglish.getText());
        Assert.assertEquals("Viber", userAnotherMessenger.getText());
        Assert.assertEquals("+123456789", userAnotherMessengerField.getAttribute("value"));

    }
}
