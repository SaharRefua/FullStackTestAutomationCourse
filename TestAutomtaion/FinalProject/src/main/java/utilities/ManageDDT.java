package utilities;

import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class ManageDDT extends CommonOps{
    @DataProvider(name = "csvReader")
    public static Object[][] getDataFromCSV(){
        String csvFile = getData("DDT_CSV_File");
        return getDataObject(csvFile);
    }
    public static List<String> reaCSV(String csvFile){
        List<String> liens = null;
        File file = new File(csvFile);

        try{
            liens = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e);
        }
        return liens;
    }


    public static Object[][] getDataObject(String csvFile){
        List<String> csvData = reaCSV(csvFile);
        Object[][] data = new Object[3][2];
        for (int i = 0; i < csvData.size(); i++) {
            data[i][0] = csvData.get(i).split(",")[0];
            data[i][1] = csvData.get(i).split(",")[1];
        }
        return data;
    }

}
