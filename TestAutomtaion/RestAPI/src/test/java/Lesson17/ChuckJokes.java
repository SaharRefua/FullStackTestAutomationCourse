package Lesson17;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;
import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class ChuckJokes extends ChuckBase
{
	@BeforeClass
	public void startSession() {
		RestAssured.baseURI = url;
		httpRequest = RestAssured.given();
	}

	@Test
	public void test01_printCategories() {
		jp = getJsonPath("categories");		
		printListJokes();
	}

	@Test
	public void test02_BarackOrCharlie() {
		if(getSearchSize("Barack Obama") > getSearchSize("Charlie Sheen"))
			System.out.println("Barack Obama (" + getSearchSize("Barack Obama") + ") has more Jokes than Charlie Sheen (" + getSearchSize("Charlie Sheen") + ")");
		else if (getSearchSize("Barack Obama") < getSearchSize("Charlie Sheen"))
			System.out.println("Charlie Sheen (" + getSearchSize("Charlie Sheen") + ") has more Jokes than Barack Obama (" + getSearchSize("Barack Obama") + ")");
		else
			System.out.println("They both have the same amount of jokes: " + getSearchSize("Barack Obama"));
	}

	@Test
	public void test03_insertToCSV() throws IOException {
		for(int i = 0; i < 10; i++) {
			jp = getJsonPath("random");	
			writeCSV(jp.getString("url"), jp.getString("value"));
		}
	}

	@Test
	public void test04_checkWithSelenium() {
		jp = getJsonPath("random?category=movie");	
		String url = jp.getString("url");
		String valueAPI = jp.getString("value");
		initBrowser(url);
		try {
			String valueSelenium = driver.findElement(By.xpath("//*[@id='content']/section/blockquote/p")).getText();
			assertEquals(valueAPI, valueSelenium);
		}
		catch(Exception e) {
			System.out.println("Test failed: " + e);
			fail("Test failed: " + e);
		}
		finally {
			driver.quit();
		}
	}
}
