import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class FirstTest {

    WebDriver driver;

    @Before
    public void setUp()
    {
        System.setProperty("webdriver.gecko.driver", "/home/sziolkowski/IdeaProjects/Web_test/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(100000,TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");

    }



    @Test
    public void userRegisterValidDate() throws InterruptedException {

        String firstName = "Sebastian";
        String birthDay = "5";
        String birthMonth = "7";
        String birthYear = "1926"; //1900 - 2018
        String lastName = "Rataj";
        String accEmail = firstName+lastName+birthYear+"@gmail.com";
        String accPassword = "QXi5C";

        String company = "TT z.o.o";
        String address1 = "Poland 20-303";
        String address2 = "Cracow Street 105C";
        String city = "Lublin";
        String idState = "5";  //range 1 - 53
        String postCode = "20303";
        String uniformIdCountry = "United States";


        String otherInformation = "databasedrop";
        String homePhoneNumber = "777-321-311";
        String mobilePhoneNumber = "312-312-432";

        String aliasAdress = "www.tribute.com";




        driver.findElement(By.cssSelector("[title=\"Log in to your customer account\"]")).click();

        Thread.sleep(3000);
        driver.findElement(By.id("email_create")).sendKeys(accEmail);
        driver.findElement(By.name("SubmitCreate")).click();

        Thread.sleep(3000);


        //YOUR PERSONAL INFORMATION
        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("customer_firstname")).sendKeys(firstName);
        driver.findElement(By.id("customer_lastname")).sendKeys(lastName);
        driver.findElement(By.id("passwd")).sendKeys(accPassword);


            //BirthDate
        new Select(driver.findElement(By.id("days"))).selectByValue(birthDay);
        new Select(driver.findElement(By.id("months"))).selectByValue(birthMonth);
        new Select(driver.findElement(By.id("years"))).selectByValue(birthYear);


        //YOUR ADDRESS
        driver.findElement(By.id("firstname")).clear();
        driver.findElement(By.id("firstname")).sendKeys(firstName);
        driver.findElement(By.id("lastname")).clear();
        driver.findElement(By.id("lastname")).sendKeys(lastName);

        driver.findElement(By.id("address1")).sendKeys(address1);
        driver.findElement(By.id("city")).sendKeys(city);
        new Select(driver.findElement(By.id("id_state"))).selectByValue(idState);
        driver.findElement(By.id("postcode")).sendKeys(postCode);


        new Select(driver.findElement(By.id("id_country"))).selectByVisibleText(uniformIdCountry);

        driver.findElement(By.id("phone_mobile")).sendKeys(mobilePhoneNumber);
        driver.findElement(By.id("alias")).sendKeys(aliasAdress);

        //notRequest
        driver.findElement(By.id("company")).sendKeys(company);
        driver.findElement(By.id("address2")).sendKeys(address2);
        driver.findElement(By.id("other")).sendKeys(otherInformation);
        driver.findElement(By.id("phone")).sendKeys(homePhoneNumber);

        driver.findElement(By.id("submitAccount")).click();
        Thread.sleep(3000);

        Boolean isCreated = driver.findElement(By.className("info-account")).isDisplayed();
        Assert.assertTrue(isCreated);

    }


    @After
    public void takeDown() throws InterruptedException {
        Thread.sleep(5000);
       driver.quit();
    }

}
