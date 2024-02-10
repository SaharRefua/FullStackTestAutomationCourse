package ChatGpt;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RequestHandler {
    public static final String MODEL_NAME = "text-davinci-003";
    public static final double TEMPERATURE = 0.5;
    public static final int MAX_TOKENS = 500;

    public static Response sendRequest() {
        RestAssured.baseURI = Config.BASE_URI;
        return RestAssured.given()
                .header("Authorization", "Bearer " + Config.API_KEY)
                .contentType(ContentType.JSON)
                .request()
                .body(createRequestBody())
                .post("/v1/completions");
    }

    private static String createRequestBody() {

        return "{\n" +
                "    \"model\": \"" + MODEL_NAME + "\",\n" +
                "    \"prompt\": \"Write java code to " + CodeGenerator.PROMPT + ". Provide only code, no text\",\n" +
                "    \"max_tokens\": " + MAX_TOKENS + ",\n" +
                "    \"temperature\": " + TEMPERATURE + "\n" +
                "}";
    }

    public static void handleResponse(Response response) {
        if (response.getStatusCode() == 200) {
            String responseText = response.jsonPath().getString("choices[0].text");
            FileWriterHandler.writeToFile(responseText,Config.FILE_TYPE);
        } else {
            System.err.println("Request failed with status code: " + response.getStatusCode());
            // Handle the failure gracefully or throw a custom exception
        }
    }
}