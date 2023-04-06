package org.ulkhnv.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.ulkhnv.model.Object;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class JSONParser implements Parser {

    @Override
    public List<Object> parse(String filePath) {
        try {
            Gson gson = new Gson();
            Type listType = new TypeToken<List<java.lang.Object>>() {
            }.getType();
            return gson.fromJson(new FileReader(filePath), listType);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error while parsing JSON: " + e.getMessage());
        }
        return null;
    }
}
