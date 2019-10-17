import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class BingSearchTests {
    WebDriver driver;


    @Test
    public void test01() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Irina\\IdeaProjects\\septJavaTestNG\\src\\test\\resources\\drivers\\geckodriver.exe");

        openBrowser();
        navigateToMainPage();
       // findElementInThePage();
        //typeQuory();
       // submitTypedQuory();
        }

    private void navigateToMainPage() {
        String url = "https://www.bing.com";
        driver.get(url);
    }

    private void openBrowser() {
        driver = new FirefoxDriver();
    }


}

