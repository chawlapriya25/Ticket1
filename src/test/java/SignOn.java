import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SignOn extends setUp {


    //Validate sign-on link is working?
    @Test(priority = 1)
    public void SignOnLink() {
        driver.findElement(By.linkText("SIGN-ON")).click();
        String title = driver.getTitle();
        Assert.assertEquals(title, "Sign-on: Mercury Tours");

    }

    //Validate register link is working?
    @Test(priority = 2)
    public void RegisterLink() {

        driver.findElement(By.linkText("REGISTER")).click();
        String title = driver.getTitle();
        Assert.assertEquals(title, "Register: Mercury Tours");

    }

    //Validate support link is working?
    @Test(priority = 3)
    public void Supportlink() {

        driver.findElement(By.linkText("SUPPORT")).click();
        String title = driver.getTitle();
        //  Assert.assertEquals(title, "Support: Mercury Tourss");


    }

    //Validate contact link is working?
    @Test(priority = 4)
    public void ContactLink() {
        driver.findElement(By.linkText("CONTACT")).click();
        String title = driver.getTitle();
        //   Assert.assertEquals(title, "Contact: Mercury Tourss");
        driver.navigate().back();
    }

    //   validate title check after login and search flight
    @DataProvider(name = "data-provider")
    public Object[][] loginMethod() {
        //  return new Object[][]
        Object[][] newdata1 = new Object[2][2];

        newdata1[0][0] = "abc@gmail.com";
        newdata1[0][1] = "1234";
        newdata1[1][0] = "cde@gmail.com";
        newdata1[1][1] = "456";
        return newdata1;
    }

    @Test(dataProvider = "data-provider", priority = 5)
    public void LogIn(String username, String password) {
        driver.navigate().to("http://demo.guru99.com/test/newtours/index.php");
        driver.findElement(By.name("userName")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("submit")).click();
        String title = driver.getTitle();

        if (title.equals("Login: Mercury Tours")) {
            Assert.assertEquals(title, "Login: Mercury Tours");
            driver.findElement(By.linkText("Flights")).click();
        } else {
            Assert.fail();


        }
    }

    //if test 5 and 6 are same how can i make it same an di dont have to write it down again.
    //Validate sign-in feature is working?
    @Test(priority = 6)
    public void SignIn() {
        driver.navigate().to("http://demo.guru99.com/test/newtours/index.php");
        driver.findElement(By.name("userName")).sendKeys("abc@gmail.com");
        driver.findElement(By.name("password")).sendKeys("1234");
        driver.findElement(By.name("submit")).click();
        String title = driver.getTitle();
        Assert.assertEquals(title, "Login: Mercury Tours");
    }

    //Validate sign-in, searching, buying ticket flow is working?
    @Test(dependsOnMethods = {"SignIn"})
    public void flow() throws InterruptedException {
        driver.findElement(By.linkText("Flights")).click();
        WebElement type = driver.findElement(By.xpath(" /html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td" +
                "/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/b/font/input[2]"));
        type.click();
        System.out.println(type.isSelected());

        WebElement passengers = driver.findElement(By.name("passCount"));
        Select select = new Select(passengers);
        select.selectByValue("3");
        System.out.println(passengers.isSelected());

        Select departingFrom = new Select(driver.findElement(By.name("fromPort")));
        departingFrom.selectByValue("New York");

        Select OnMonth = new Select(driver.findElement(By.name("fromMonth")));
        OnMonth.selectByVisibleText("March");

        Select OnDate = new Select(driver.findElement(By.name("fromDay")));
        OnDate.selectByVisibleText("5");

        Select ArrivingIn = new Select(driver.findElement(By.name("toPort")));
        ArrivingIn.selectByVisibleText("London");

        Select toMonth = new Select(driver.findElement(By.name("toMonth")));
        toMonth.selectByVisibleText("March");

        Select toDay = new Select(driver.findElement(By.name("toDay")));
        toDay.selectByVisibleText("21");

        WebElement Preferences = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4" +
                "]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/font/input[1]"));
        Preferences.click();

        WebElement Airline = driver.findElement(By.name("airline"));
        Select airline = new Select(Airline);
        airline.selectByVisibleText("Blue Skies Airlines");

        WebElement Continue = driver.findElement(By.name("findFlights"));
        Continue.click();


    }
}
//git
//push branch tc0076 wth name to origin
//create pull request to  merge branch tc0076  with master


//for 8
//create branch for 8
//push branch 8 to rigin
//smae as 7