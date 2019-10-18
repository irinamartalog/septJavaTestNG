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
        driverFindElements();
        clickOnFirstCheckbox();
        unclickOnSecondCheckbox();
    }



    private void unclickOnSecondCheckbox() {

        driver.findElement(By.cssSelector(checkBox2)).click();
    }

    private void clickOnFirstCheckbox() {

        driver.findElement(By.cssSelector(checkBox1)).click();
    }

    private void driverFindElements() {
        List<WebElement> elements = driver.findElements(By.tagName("input"));
        int numberOfElements = elements.size();
        Assert.assertTrue(numberOfElements == 2);
        /*WebElement checkBox1 = elements.get(0);
        WebElement checkBox2 = elements.get(1);
        boolean isDisplayedCheckBox1 = checkBox1.isDisplayed();
        Assert.assertTrue(isDisplayedCheckBox1);
        boolean isDisplayedCheckBox2 = checkBox2.isDisplayed();
        Assert.assertTrue(isDisplayedCheckBox2);
    }
       /* String checkBox1Value = checkBox1.getAttribute("checked");
        if (checkBox1Value == null) {
            checkBox1.click();
        }
        String checkBox2Value = checkBox2.getAttribute("checked");
        if (checkBox2Value == null) {
            checkBox2.click();
        */}


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

