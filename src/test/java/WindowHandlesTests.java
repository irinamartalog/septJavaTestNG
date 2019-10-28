import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WindowHandlesTests {
    WebDriver driver;
    WebElement link;

     @AfterMethod
     public void afterMethod (){
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

    @Test
    public void test111() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Irina\\IdeaProjects\\septJavaTestNG\\src\\test\\resources\\drivers\\geckodriver.exe");


        openBrowser();
        navigateToThePage();
        findLinkElementOnPage();
        assertResultElementOnPage();
        windowHandlesSize();
        switchToWindowHandle1();
        switchToWindowHandle2();
        assertWindowHandle2Result();
    }

    private void assertWindowHandle2Result() {
        WebElement actualPageTextPresented = driver.findElement(By.tagName("h3"));
        boolean isDisplayedText = actualPageTextPresented.isDisplayed();
        boolean expectedPageTextPresented = true;
        Assert.assertEquals(isDisplayedText,expectedPageTextPresented);
    }


    private void switchToWindowHandle2() {
        Object[] arrayOfHandles = driver.getWindowHandles().toArray();
        String handle1 = (String) arrayOfHandles[0];
        String handle2 = (String) arrayOfHandles[1];
        driver.switchTo().window(handle2);
    }



    private void switchToWindowHandle1() {
        Object[] arrayOfHandles = driver.getWindowHandles().toArray();
        String handle1 = (String) arrayOfHandles[0];
        String handle2 = (String) arrayOfHandles[1];
        driver.switchTo().window(handle1);

    }

    private void windowHandlesSize() {
        int sizeOfHandles = driver.getWindowHandles().size();
        Assert.assertEquals(sizeOfHandles,2);
    }


    private void assertResultElementOnPage() {
       WebElement link =  driver.findElement(By.linkText("Click Here"));
        String actualHrefValue = link.getAttribute("href");
        String expectedHrefValue = "http://the-internet.herokuapp.com/windows/new";
        Assert.assertEquals(actualHrefValue,expectedHrefValue);
        link.click();
   }

    private void findLinkElementOnPage() {
        String link = "Click Here";
        driver.findElement(By.linkText(link));
    }

    private void navigateToThePage() {
    String url = "http://the-internet.herokuapp.com/windows";
    driver.get(url);

    }

    private void openBrowser() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
