package Lesson12;

import org.testng.annotations.DataProvider;

public class data {
    @DataProvider(name = "searchData")
    public Object[][] searchData() {
        return new Object[][]{
                {"Selenium","Selenium"},
                {"Appium","Appium"},
                {"Israel","Israel"},
                {"Pizza","Pizza"},
        };
    }
}
