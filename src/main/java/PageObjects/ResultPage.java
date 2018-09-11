package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultPage {
    @FindBy(name = "q")
    WebElement searchField;
    @FindBy(xpath = "//a[@class='pn' and contains(.,'Уперед')]")
    WebElement nextPageButton;

    WebDriver driver;

    public ResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ResultPage search(String text) {
        searchField.sendKeys(text);
        searchField.submit();
        return this;
    }

    public ResultPage clickNextPageButton() {
        nextPageButton.click();
        return this;
    }
}
