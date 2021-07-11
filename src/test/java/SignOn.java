import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SignOn extends setUp {


    //Validate sign-on link is working?
    @Test
    public void SignOnLink() {
        driver.findElement(By.linkText("SIGN-ON")).click();
        String title = driver.getTitle();
        Assert.assertEquals(title, "Sign-on: Mercury Tours");
        driver.navigate().back();
    }

    //Validate register link is working?
    @Test
    public void RegisterLink() {

        driver.findElement(By.linkText("REGISTER")).click();
        String title = driver.getTitle();
        Assert.assertEquals(title, "Register: Mercury Tours");
        driver.navigate().back();
    }

    //Validate support link is working?
    @Test
    public void Supportlink() {
        driver.findElement(By.linkText("SUPPORT")).click();
        String title = driver.getTitle();
        Assert.assertEquals(title, "Support: Mercury Tourss");
        driver.navigate().back();

    }

    //Validate contact link is working?
    @Test
    public void ContactLink() {
        driver.findElement(By.linkText("CONTACT")).click();
        String title = driver.getTitle();
        Assert.assertEquals(title, "Contact: Mercury Tourss");
        driver.navigate().back();
    }

    //   validate title check after login and search flight
   @DataProvider(name="data-provider")
   public Object[][] loginMethod(){
        return new Object[][]
                {
                        {"abc@gmail.com"},{"1234"},
                        {"cde@gmail.com"},{"456"}

                };
   }
    @Test(dataProvider = "data-provider")
    public void LogIn(String username,String password) {
        driver.navigate().to("http://demo.guru99.com/test/newtours/index.php");
        driver.findElement(By.name("userName")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("submit")).click();
        driver.findElement(By.linkText("Flights")).click();
        String title = driver.getTitle();
        Assert.assertEquals(title, "Find a Flight: Mercury Tours: ");
        if (title.equals("Find a Flight: Mercury Tours:")) {
            Assert.assertTrue(true);
            System.out.println("Passed");
        } else {
            Assert.assertFalse(false,"Fail,only register user can login");

        }
    }


    //Validate sign-in feature is working?
    @Test
    public void SignIn() {
        driver.navigate().to("http://demo.guru99.com/test/newtours/index.php");
        driver.findElement(By.name("userName")).sendKeys("abc@gmail.com");
        driver.findElement(By.name("password")).sendKeys("1234");
        driver.findElement(By.name("submit")).click();
        String title=driver.getTitle();
        Assert.assertEquals(title, "Login: Mercury Tours");
    }

    //Validate sign-in, searching, buying ticket flow is working?

}