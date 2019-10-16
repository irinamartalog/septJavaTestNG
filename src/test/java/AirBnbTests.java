import com.sun.org.apache.bcel.internal.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;



public class AirBnbTests {
    WebDriver driver;
    String firstElement = "#Koan-magic-carpet-koan-search-bar__input";
    String url = "https://www.airbnb.com";


    @Test
    public void testFirst() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Irina\\IdeaProjects\\septJavaTestNG\\src\\test\\resources\\drivers\\geckodriver.exe");

       openBrowser();
        navigateToMainPage();
        findElement();
        typeQuory();
       // selectTypeQuory();
       //selectCheckInDate();
       // selectCheckOutDate();
        dropDownGuests();
        //submitSaveButton();
       // submitSearch();
       // assertResulstPage();





    }

    private void dropDownGuests() {

    }


    //private void selectCheckInDate() {
       //String checkInDate = "checkin_input";
      // Select selectId = new Select(driver.findElement(By.id(checkInDate)));
      // selectId.selectByValue("18");
   // }

   // private void selectTypeQuory() {



        // WebElement dropdown = driver.findElement(By.cssSelector("#Koan-magic-carpet-koan-search-bar__option-0 > div:nth-child(2) > div:nth-child(1)"));
        //dropdown.click();

//             }



    private void typeQuory() {
        String firstElement = "#Koan-magic-carpet-koan-search-bar__input";
        WebElement webElement = driver.findElement(By.cssSelector(firstElement));
        webElement.sendKeys("Big Bear Lake, Ca");
    }

    private void findElement() {

        driver.findElement(By.cssSelector("#Koan-magic-carpet-koan-search-bar__input"));
    }

    private void navigateToMainPage() {
        String url = "https:/www.airbnb.com";
        driver.get(url);
    }

    private void openBrowser() {
        driver = new FirefoxDriver();
    }
}
