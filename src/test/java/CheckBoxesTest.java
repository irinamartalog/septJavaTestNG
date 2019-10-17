import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

public class CheckBoxesTest {
    WebDriver driver;
    String resultStatsID ="resultStatsID";
    @BeforeSuite
    public void setUp(){
        System.setProperty("webdriver.gecko.driver","C:\\Users\\Irina\\IdeaProjects\\septJavaTestNG\\src\\test\\resources\\drivers\\geckodriver.exe");
    }
}
