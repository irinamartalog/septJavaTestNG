import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class YahooTests {
    WebDriver driver;
    String selector = "title";
    String indeedElement = "page-logo";


    @AfterSuite

    public void afterSuite() {
        driver.quit();
    }

    @Test
    public void test001() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Irina\\IdeaProjects\\septJavaTestNG\\src\\test\\resources\\drivers\\geckodriver.exe");


        openBrowser();
        navigateToMainMenu();
        typeQuory();
        submitSearch();
        assertResulstPage();
       // waitForResultsElementPage();
        navigateToTheUrl2();
        assertResulstPage2();
        clickOnContactUs();
        typeFirstName();
        typeLastName();
        typeEmail();
        typeCompany();



    }

    private void typeCompany() {
        String company = "input-25";
        WebElement webElementCompany = driver.findElement(By.id(company));
        webElementCompany.sendKeys("United Games Studio");
    }

    private void typeEmail() {
        String email = "input-24";
        WebElement webElementEmail = driver.findElement(By.id(email));
        webElementEmail.sendKeys("AntonioHilt@gmail.com");
    }

    private void typeLastName() {
        String lastName = "input-23";
        WebElement webElementLastName = driver.findElement(By.id(lastName));
        webElementLastName.sendKeys("Hilt");
    }

    private void typeFirstName() {
     String firstName = "input-22";
     WebElement webElementName = driver.findElement(By.id(firstName));
     webElementName.sendKeys("Antonio");
    }


    private void clickOnContactUs() {
        String contactUs = ".contact-btn";
         driver.findElement(By.cssSelector(contactUs)).click();

    }

    private void assertResulstPage2() {
        WebElement webElementPage = driver.findElement(By.className(indeedElement));
        boolean isVisible = webElementPage.isDisplayed();
        boolean expected = true;
        Assert.assertEquals(isVisible,expected);
    }

    private void navigateToTheUrl2() {
        String url2 =" https://r.search.yahoo.com/cbclk2/dWU9MjREOTc5MEEyOUQzNEVGMyZ1dD0xNTcxMzI4OTA0MTEzJnVvPTc4NjE1MDg5ODA0MTgxJmx0PTImcz0xJmVzPUFCR0JhbHdHUFM5b2dBOGhlWnpyTURyS1JzNlRKdGxBZ1lWSEpfWTNSenFwd19jUDN3LS0-/RV=2/RE=1571357704/RO=10/RU=https%3a%2f%2fwww.bing.com%2faclick%3fld%3de3DCIv9m9IsPSXRQ-ogxMenzVUCUzvqWlSnMst9hgmeiJSPPjhgOiY5I0etKL69oP45B_oBmx0Uske6Yz-S2kRnUH5AQUIOTY-Zz_FcgAqgqYbKJlGyio1hA2lOT-C0d0-FbysDvyEBU0x9M8WtbYqdUVzG0Uox8ykWM5hq-22DNFaMMU2%26u%3daHR0cCUzYSUyZiUyZnd3dy5pbmRlZWQuY29tJTJmaGlyZSUyZmpvYi1kZXNjcmlwdGlvbiUyZnF1YWxpdHktZW5naW5lZXIlM2ZrdyUzZHF1YWxpdHklMmJlbmdpbmVlciUyYmpvYiUyYmRlc2NyaXB0aW9uJTI2c2lkJTNkdXNfbXNuc3JjaGhhakV4YWN0am9iZGVzLXF1YWxpdHklMmJlbmdpbmVlciUyYmpvYiUyYmRlc2NyaXB0aW9uJTI2bWF0Y2h0eXBlJTNkYmUlMjZuZXR3b3JrJTNkc2VhcmNoJTI2ZGV2aWNlJTNkYyUyNmtleXdvcmQlM2RxdWFsaXR5JTI1MjBlbmdpbmVlciUyNTIwam9iJTI1MjBkZXNjcmlwdGlvbiUyNnF1ZXJ5JTNkcWElMjUyMGVuZ2luZWVyJTI1MjBqb2IlMjUyMGRlc2NyaXB0aW9uJTI2dXRtX3NvdXJjZSUzZGJpbmclMjZ1dG1fbWVkaXVtJTNkY3BjJTI2dXRtX3Rlcm0lM2RxdWFsaXR5JTJiZW5naW5lZXIlMmJqb2IlMmJkZXNjcmlwdGlvbiUyNnV0bV9jYW1wYWlnbiUzZGpvYiUyYmRlc2NyaXB0aW9uJTJicGFnZXMlMmJ0aXRsZSUyYjAlMmIlMjUyOGV4YWN0JTI1MjklMjZ1dG1fbWVkaXVtJTNkY3BjJTI2dXRtX3NvdXJjZSUzZGdvb2dsZV9zZWFyY2glMjZ1dG1fY2FtcGFpZ24lM2QzMTgwOTMwOCUyNnV0bV90ZXJtJTNka3dkLTMxMDg1NTYwMjIyJTNhbG9jLTE5MCUyNm1zY2xraWQlM2QzNjQyYzNlYjBmYTQxOGU4YjgyYzllNDM5YzJjNGZhNCUyNnV0bV9jb250ZW50JTNkcXVhbGl0eSUyNTIwZW5naW5lZXIlMjUyMGpvYiUyNTIwZGVzY3JpcHRpb24%26rlid%3d3642c3eb0fa418e8b82c9e439c2c4fa4/RK=2/RS=qjbqdZxIYhIqSXITXHoSPxSwPFk-;_ylt=Awr9DJaIk6hdNOAAY5JXNyoA;_ylu=X3oDMTE2dGgzc2QxBGNvbG8DZ3ExBHBvcwMxBHZ0aWQDQTA2MTVfMQRzZWMDb3YtdG9w;_ylc=X3IDMgRydAMw?p=qa+engineer+job+description&IG=0afd0c9619f045298400000000574789";
        driver.get(url2);
    }

   // private void waitForResultsElementPage() {
       /* By elemenWaitOnPage = By.className(selector);
        ExpectedCondition condition = ExpectedConditions.presenceOfElementLocated(elemenWaitOnPage);
        WebDriverWait webDriverWait = new WebDriverWait(driver, 15);
        By elementToWaitPage = By.className(selector);
        ExpectedCondition condition = ExpectedConditions.presenceOfElementLocated(elementToWaitPage);
        WebDriverWait webDriverWait = new WebDriverWait(driver, 25);*/




    private void assertResulstPage() {
        WebElement staticResultID = driver.findElement(By.className(selector));
        boolean isDisplayed = staticResultID.isDisplayed();
        boolean expected = true;

        Assert.assertEquals(isDisplayed,expected);
    }

    private void submitSearch() {
        String id = "uh-search-box";
        driver.findElement(By.id(id)).submit();
    }

    private void typeQuory() {
        String id = "uh-search-box";
        WebElement webElement = driver.findElement(By.id(id));
        webElement.sendKeys("qa engineer job description ");
    }


    private void navigateToMainMenu() {
        String url = "https://www.yahoo.com/";
        driver.get(url);
    }

    private void openBrowser() {

         driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
