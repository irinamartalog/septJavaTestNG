import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckBoxesTest {
    WebDriver driver;
    List<WebElement> elements;
    String checkBox1 = " #checkboxes > input:nth-child(1)";
    String checkBox2 = "#checkboxes > input:nth-child(3)";

    @AfterSuite
     public void afterSuite(){
     driver.quit();
    }

    @Test
    public void test0001() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Irina\\IdeaProjects\\septJavaTestNG\\src\\test\\resources\\drivers\\geckodriver.exe");

        openBrowser();
        navigateToCheckBoxesPage();
        findCheckBoxesElementOnPage();
        clickOnFirstCheckbox();
        unclickOnSecondCheckbox();
    }


    private void unclickOnSecondCheckbox() {

        driver.findElement(By.cssSelector(checkBox2)).click();

    }

    private void clickOnFirstCheckbox() {

        driver.findElement(By.cssSelector(checkBox1)).click();
    }



    private void findCheckBoxesElementOnPage() {
        List<WebElement> elements = driver.findElements(By.tagName("input"));
        int numberOfElements = elements.size();
        Assert.assertTrue(numberOfElements == 2);
    }


        private void navigateToCheckBoxesPage ()
    {
            String url = "https://the-internet.herokuapp.com/checkboxes";
            driver.get(url);
        }

        private void openBrowser ()
    {
            driver = new FirefoxDriver();
        }

}

