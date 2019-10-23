import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BingSearchTest {
    WebDriver driver;
    String classNameElement = "b_searchbox";
    String resultsSelector = ".sb_count";

    @Test
    public void test1() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Irina\\IdeaProjects\\septJavaTestNG\\src\\test\\resources\\drivers\\geckodriver.exe");

        openBrowser();
        navigateToMainPage();
        typeQuory();
        submitSearch();
        assertResulstPage();
        navigateToTheNewLink();
        goBackToTheResultsPage();
    }

    private void goBackToTheResultsPage() {
        driver.navigate().back();
    }


    private void navigateToTheNewLink() {
        String newLink = "https://www.amazon.com/Movies/b?node=2858905011";
        driver.get(newLink);

    }

    private void assertResulstPage(){

     WebElement resultsSelector = driver.findElement(By.cssSelector(".sb_count"));
     boolean displayedResult = resultsSelector.isDisplayed();
     boolean expectedResult = true;
      Assert.assertEquals(displayedResult,expectedResult);
    }



    private void submitSearch() {
        driver.findElement(By.className(classNameElement)).submit();
    }

    private void typeQuory() {

        WebElement searchLine = driver.findElement(By.className(classNameElement));
        searchLine.sendKeys("Amazon prime video");

    }


    private void navigateToMainPage() {
        String mainPage = "https://www.bing.com/";
        driver.get(mainPage);
    }

    private void openBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


}

