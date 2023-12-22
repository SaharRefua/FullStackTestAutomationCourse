package Lesson08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class controllers {
    WebDriver driver;


    @Test
    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://atidcollege.co.il/Xamples/ex_controllers.html");

    }

    @Test
    public void test01_nameAndContinents() {
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Moshe");
        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Cohen");
        Select continents = new Select(driver.findElement(By.id("continents")));
        continents.selectByVisibleText("Europe");
        WebElement submit = driver.findElement(By.id("submit"));
        submit.submit();
        String url = driver.getCurrentUrl();
        System.out.println(url);
        if (url.contains("firstname=Moshe") && url.contains("lastname=Cohen")
                && url.contains("continents=europe")) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

    }

    @Test
    public void test02_bonus() {
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Moshe");
        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Cohen");
        Select continents = new Select(driver.findElement(By.id("continents")));
        continents.selectByVisibleText("Australia");
        WebElement experience = driver.findElement(By.id("exp-6"));
        experience.click();
        WebElement date = driver.findElement(By.name("datepicker"));
        date.sendKeys("05/01/2021");
        date.sendKeys(Keys.RETURN);

        WebElement profession = driver.findElement(By.id("profession-1"));
        profession.click();
        WebElement automationTool = driver.findElement(By.id("tool-1"));
        automationTool.click();

        WebElement submit = driver.findElement(By.id("submit"));
        submit.submit();

        String url = driver.getCurrentUrl();
        System.out.println(url);
        String [] urls = url.split("=");
        String [] dateParams = urls[5].split("%2F");
        System.out.println("day :" +dateParams[0]);
        System.out.println("month :" +dateParams[1]);
        System.out.println("year :" +dateParams[2].split("&")[0]);
        System.out.println("date is : "+ dateParams[2].split("&")[0]+"-"+dateParams[1]+"-"+dateParams[0]);
    }


    @Test
    @AfterClass
    public void afterClass() {

        driver.quit();

    }


}
