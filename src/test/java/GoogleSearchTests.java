import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GoogleSearchTests {
    WebDriver driver;
    String resultStatsId = "resultStats";


@AfterSuite

    public void afterSuite() {
    driver.quit();
    }


    @Test
    public void test0001() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Irina\\IdeaProjects\\septJavaTestNG\\src\\test\\resources\\drivers\\geckodriver.exe");


            openBrowser();
            navigateToMainPage();
            typeQuory();
            submitSearch();
            assertResulstPage();
            waitForResultsElement();
            //implisitwait;
            //explicitwait;

    }

    private void waitForResultsElement() {
    By elementToWait = By.id("resultsStatsId");
    ExpectedCondition condition = ExpectedConditions.presenceOfElementLocated(elementToWait);
    WebDriverWait webDriverWait = new WebDriverWait(driver, 20);

    webDriverWait.until(condition);
    }

    private void assertResulstPage() {

    WebElement resultsStatsId = driver.findElement(By.id(resultStatsId));

    boolean isDisplayed = resultsStatsId.isDisplayed();
    boolean expected = true;
        Assert.assertEquals(isDisplayed,expected);
    }


    private void submitSearch() {
        String selector = ".gLFyf";
        driver.findElement(By.cssSelector(selector)).submit();
    }

    private void typeQuory() {
        String selector = ".gLFyf";
       WebElement webElement =  driver.findElement(By.cssSelector(selector));
       webElement.sendKeys("Portnov computer school");
    }

    private void navigateToMainPage() {
        String url = "https:/www.google.com";
        driver.get(url);
    }

    private void openBrowser() {
        driver = new FirefoxDriver();
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
}
