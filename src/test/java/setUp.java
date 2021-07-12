import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class setUp {
    public static WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "/Users/priya/Documents/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("http://demo.guru99.com/test/newtours/login.php");
    }

    @AfterTest
    public void tearDown() {
        try {
            driver.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
