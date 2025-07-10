package utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JsonDataReader {
    private static final Logger log= LoggerFactory.getLogger(JsonDataReader.class);
    private Map<String, Object> data;

    public JsonDataReader(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            data = objectMapper.readValue(new File(filePath), Map.class);
        } catch (IOException e) {
            log.info(e.getMessage());
            throw new RuntimeException("Failed to read JSON data from file: " + filePath, e);
        }
    }
    public String getString(String key) {
        return (String) data.get(key);
    }

    public int getInt(String key) {
        return (Integer) data.get(key);
    }

    public Object getObject(String key) {
        return data.get(key);
    }
    public Map<String, Object> getNestedObject(String key) {
        return (Map<String, Object>) data.get(key);
    }

    // Overloaded method to get a nested value by providing a nested path
    public String getNestedString(String parentKey, String childKey) {
        Map<String, Object> nestedObject = getNestedObject(parentKey);
        if (nestedObject != null) {
            return (String) nestedObject.get(childKey);
        }
        return null;
    }


}
