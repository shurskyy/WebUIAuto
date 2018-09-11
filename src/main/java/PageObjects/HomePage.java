package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    @FindBy(name = "q")
    WebElement searchField;

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public HomePage openPage(){
        driver.get("https://www.google.com");
        return this;
    }

    public ResultPage search(String text) {
        searchField.sendKeys(text);
        searchField.submit();
        return new ResultPage(driver);
    }
}
