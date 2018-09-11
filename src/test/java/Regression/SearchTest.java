package Regression;

import Helper.LogsInit;
import PageObjects.HomePage;
import PageObjects.ResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SearchTest {
    WebDriver driver;

    @BeforeMethod
    private void initializeDriver() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        LogsInit logsInit = new LogsInit();
        driver = new FirefoxDriver(logsInit.initializeCapabilities(logsInit.getLoggingPreferences()));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testSearch() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        ResultPage resultPage = homePage.openPage().search("Rammstein");
        resultPage.clickNextPageButton();
        Thread.sleep(5000);
    }

    @AfterMethod
    private void closeDriver() {
        driver.close();
    }
}
