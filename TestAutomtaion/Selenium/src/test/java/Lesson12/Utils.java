package Lesson12;

import org.testng.annotations.DataProvider;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class Utils {
    @DataProvider(name="data-provider-csv")
    public Object[][] getDataObject(){
        return getDataFromCSV("/Users/sahar.refua/saharR/FullStackTestAutomationCourse/TestAutomtaion/Selenium/src/test/java/Lesson12/data.csv");
    }
    public static Object[][] getDataFromCSV(String filePath) {
    Object[][] data = new Object[5][2];
    List<String> csvData= readCSV(filePath);
    for (int i=0; i<csvData.size(); i++){
        data[i][0] = csvData.get(i).split(",")[0];
        data[i][1] = csvData.get(i).split(",")[1];
    }

    return data;
    }
    public static List<String> readCSV(String csvFile) {
        List<String> lines = null;
        File file = new File(csvFile);
        try {
            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);

        } catch (IOException  e) {
            System.out.println("Some Error , See Details,  " + e);
        }
        return lines;

    }

}
