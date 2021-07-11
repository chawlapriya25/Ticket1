import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public  class setUp {
 public   static  WebDriver driver;
    @BeforeClass(alwaysRun = true)
    public void setUp(){

        System.setProperty("webdriver.chrome.driver","/Users/priya/Documents/chromedriver");
         driver=new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().deleteAllCookies();
         driver.get("http://demo.guru99.com/test/newtours/login.php");
    }

    @AfterClass
    public void tearDown(){
        try{
            driver.close();
        }catch(Exception e){
           e.printStackTrace();
        }
    }

}
