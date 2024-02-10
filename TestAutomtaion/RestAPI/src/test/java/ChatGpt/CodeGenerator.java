package ChatGpt;

import io.restassured.response.Response;

import java.util.Scanner;

public class CodeGenerator {
    public static String PROMPT;
    public static String FILE_NAME;
    public static void main(String[] args) throws InterruptedException {

         PROMPT = getUserInput("Please enter your prompt:\n");
         FILE_NAME = getUserInput("Provide me a file name to save the answer:\n");


        System.out.println("Prompt is: " + PROMPT);
        System.out.println("File name is: " + FILE_NAME);

        Response response = RequestHandler.sendRequest();
        displayLoadingMessage();
        RequestHandler.handleResponse(response);
    }

    private static String getUserInput(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        String input = null;
        input = scanner.nextLine();
        return input;
    }

    private static void displayLoadingMessage() throws InterruptedException {
        String[] loadingDots = {".", "..", "...", "...."};

        System.out.print("Processing");
        for (int i = 0; i < 10; i++) {
            Thread.sleep(500); // Wait for half a second
            System.out.print(loadingDots[i % loadingDots.length]);
        }
        System.out.println();
    }

}