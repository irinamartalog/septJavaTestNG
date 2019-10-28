
    import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

    public class ii {

        WebDriver driver;

        @BeforeSuite
        public void setUp() {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\Irina\\IdeaProjects\\septJavaTestNG\\src\\test\\resources\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

        @Test
        public void testCheckBoxes001() {

            navigateToThePage();
            selectFirstCheckBox();

        }

        private void navigateToThePage() {
            String url = "https://the-internet.herokuapp.com/checkboxes";
            driver.get(url);
        }

        private void selectFirstCheckBox() {
            WebElement checkBox1 = driver.findElement(By.cssSelector("#checkboxes > input[type=checkbox]:nth-child(1)"));
            checkBox1.click();
            String firstCheckBoxCheckedValue = checkBox1.getAttribute("checked");
            Assert.assertEquals(firstCheckBoxCheckedValue, "true");
        }

        @Test
        public void testDeselectCheckbox002() {

            refreshThePage();
            waitForElement();
            deselectSecondCheckbox();
        }

        private void deselectSecondCheckbox() {
            WebElement checkBox2 = driver.findElement(By.cssSelector("#checkboxes > input[type=checkbox]:nth-child(3)"));
            checkBox2.click();
            String checkbox2CheckedValue = checkBox2.getAttribute("null");
            Assert.assertEquals(checkbox2CheckedValue, null);
        }

        private void refreshThePage() {
            driver.get("https://the-internet.herokuapp.com/checkboxes");
            driver.navigate().refresh();
        }

        private void waitForElement() {
            By elementToWait = By.tagName("h3");
            ExpectedCondition condition = ExpectedConditions.presenceOfElementLocated(elementToWait);
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(condition);
        }


        @AfterSuite
        public void afterSuite(){

            driver.quit();
        }


    }

