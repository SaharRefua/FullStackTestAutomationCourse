package ChatGpt;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWriterHandler {

    public static void writeToFile(String responseText, String fileType) {
        String filePath = Config.FILE_PATH + CodeGenerator.FILE_NAME + "." + fileType;
        Path outputPath = Paths.get(filePath);

        try (FileWriter fileWriter = new FileWriter(outputPath.toFile())) {
            fileWriter.write(responseText);
            System.out.println("Successfully wrote to file: " + outputPath);
        } catch (IOException e) {
            System.err.println("Failed to write to file: " + e.getMessage());
            System.exit(1);
        }
    }
}
