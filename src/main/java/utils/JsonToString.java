package utils;

import io.restassured.path.json.JsonPath;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonToString {

    public String getStringValue(String filePath, String jsonPath) {
        String jsonString = null;
        try {
            jsonString = new String(Files.readAllBytes(Paths.get(filePath)));
            System.out.println("JSON String: " + jsonString); // Debugging line
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        // Check if jsonString is null or empty
        if (jsonString == null || jsonString.isEmpty()) {
            System.out.println("JSON String is null or empty.");
            return null;
        }

        // Parse JSON and retrieve the specified value
        JsonPath js = new JsonPath(jsonString);

        // Retrieve the first label value
        try {
            return js.getString(jsonPath);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
