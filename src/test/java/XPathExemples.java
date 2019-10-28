import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.List;

public class XPathExemples {
    WebDriver driver;
    String singleAtribute = "//*[@id=\"login-username\"]";

    @AfterSuite

    public void afterSuite() {
        driver.quit();
    }


    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Irina\\IdeaProjects\\septJavaTestNG\\src\\test\\resources\\drivers\\geckodriver.exe");

    }

    @BeforeMethod
    public void beforeMethode() {
        driver = new FirefoxDriver();
        driver.get("https://login.yahoo.com/config/login?.src=fpctx&.intl=us&.lang=en-US&.done=https%3A%2F%2Fwww.yahoo.com");
    }



    @Test
    public void testXpath1() {
        //relativeXpath();
        singleAttribute();
        refreshingPage();
        multipleAttribute();
        refreshingPage2();
        usingAnd();
        usingOr();
        contains();
       // startsWith();
        text();
        last();
        // position();
        // findingElementsUsingIndex();
        //following();


    }

    private void last() {
        String lastPartOfElement = ("//id[@type='login-username'])[last()]");
        driver.findElement(By.xpath(lastPartOfElement));
    }

    private void text() {
        String partOfTheText = "//*[text()='Yahoo']";
        driver.findElement(By.xpath(partOfTheText));
    }

   /* private void startsWith() {
        String startsWithElement ="//*[starts-with(@@class,'phone-no')]";
        driver.findElement(By.xpath(startsWithElement));
    }*/

    private void contains() {
        String containsElement = "//*[contains(@class,'phone-no')]";
        driver.findElements(By.xpath(containsElement));
    }

    private void usingOr() {
        String usingOr = "//*[@id='login-signin'or@class='orko-button-primary orko-button']";
        driver.findElements(By.xpath(usingOr)); }

     private void usingAnd() {
         String usingAnd = "//*[@id='login-signin'and@class='orko-button-primary orko-button']";
         driver.findElements(By.xpath(usingAnd));

    }

    private void refreshingPage2() {
        driver.get("https://login.yahoo.com/config/login?.src=fpctx&.intl=us&.lang=en-US&.done=https%3A%2F%2Fwww.yahoo.com");
        driver.navigate().refresh();
    }

     private void multipleAttribute() {
         String multipleAttribute = "//*[@tabindex='1'][@value='']";
         WebElement element2 = driver.findElement(By.xpath(multipleAttribute));
         element2.sendKeys("arianas@gmail.com");

    }

    private void refreshingPage() {
        driver.get("https://login.yahoo.com/config/login?.src=fpctx&.intl=us&.lang=en-US&.done=https%3A%2F%2Fwww.yahoo.com");
        driver.navigate().refresh();
    }

    private void singleAttribute() {
        String singleAtribute = "//*[@id=\'login-username']";
        WebElement element1 = driver.findElement(By.xpath(singleAtribute));
       element1.sendKeys("JonAmber@gmail.com");
    }
}