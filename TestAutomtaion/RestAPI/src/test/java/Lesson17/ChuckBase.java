package Lesson17;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ChuckBase {
	protected String url = "https://api.chucknorris.io/jokes/";
	protected RequestSpecification httpRequest;
	protected Response response;
	protected JsonPath jp;
	protected WebDriver driver;
	
	public JsonPath getJsonPath(String value) {
		response = httpRequest.get(value);
		return response.jsonPath();
	}
	
	public int getSearchSize(String searchValue) {
		jp = getJsonPath("search?query=" + searchValue);	
		return jp.getList("result.id").size();
	}
	
	public void printListJokes() {
		System.out.println("List of Chuck Norris Jokes:");
		for(Object category : jp.getList("$."))
			System.out.println(category.toString());
	}
	
	public void writeCSV(String url, String value) throws IOException {
		FileWriter pw = new FileWriter("./results.csv",true); 
		StringBuilder sb = new StringBuilder();
		sb.append(url);
		sb.append(',');
		sb.append(value.replace(",", ""));
		sb.append('\n');
		pw.write(sb.toString());
		pw.close();
	}
	
	public void initBrowser(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
