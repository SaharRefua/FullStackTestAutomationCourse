package Lesson10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.print.DocFlavor;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;

import static org.testng.Assert.*;
import static org.testng.Assert.fail;

public class externalFiles {

    WebDriver driver;


    @Test
    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://atidcollege.co.il/Xamples/bmi/");

    }

    @Test
    public void test01_CalBMI() {
        try {
            WebElement weight = driver.findElement(By.id("weight"));
            String test = ReadXMLFile("Weight");
            weight.sendKeys(ReadXMLFile("Weight"));
            WebElement hight = driver.findElement(By.id("hight"));
            hight.sendKeys(ReadXMLFile("Height"));
            WebElement calBMI = driver.findElement(By.id("calculate_data"));
            calBMI.click();
            WebElement bmi = driver.findElement(By.id("bmi_result"));
            assertEquals(bmi.getAttribute("value"), ReadXMLFile("Result"));
        } catch (Exception e) {
            System.out.println("Test Failed");
            fail("Test Failed");
        }
    }


    @Test
    @AfterClass
    public void afterClass() {

        driver.quit();

    }

    public static String ReadXMLFile(String tagName) {
        try {
            File inputFile = new File("./bmiData.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("BMIData element: " + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName(tagName);
            if (nodeList.getLength() > 0) {
                Node node = nodeList.item(0);
                return node.getTextContent();
            } else {
                System.out.println("Tag not found: " + tagName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}


