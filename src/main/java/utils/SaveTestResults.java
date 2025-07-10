package utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import com.google.gson.Gson;
import org.testcontainers.shaded.org.awaitility.Awaitility;

import java.util.concurrent.TimeUnit;

public class SaveTestResults {

    public boolean SaveResults(Saves save) throws InterruptedException {
        RequestSpecification request;

        // Convert the 'save' object to a JSON string using Gson
        Gson gson = new Gson();
        String jsonBody = gson.toJson(save); // This is your raw JSON body

        System.out.println("Request Body: " + jsonBody); // For debugging purposes

        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri("https://itap.valuemomentum.com/specflowapi/api/TestResultsController/SaveSpecFlowTestResults");
        builder.setContentType(ContentType.JSON); // Set content type to JSON
        var requestSpec = builder.build();

        request = RestAssured.given().spec(requestSpec);
        request.header("Content-Type", "application/json");

        // Send the JSON body in the request
        request.body(jsonBody);

        // Send POST request
        Response response = request.post();
        System.out.println("StatusCode: " + response.getStatusCode());

        // Await for the response to ensure it gets processed
        Awaitility.await().atMost(40, TimeUnit.SECONDS).until(() -> response.getStatusCode() == 200);
        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);

        return response.getStatusCode() == 200;
    }
}
