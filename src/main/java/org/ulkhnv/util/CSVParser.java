package org.ulkhnv.util;

import com.opencsv.CSVReader;
import org.ulkhnv.model.Object;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class CSVParser implements Parser {

    @Override
    public List<Object> parse(String filePath) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            return reader.readAll()
                    .stream()
                    .skip(1)
                    .map(CSVParser::rowToObject)
                    .collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error while parsing CSV: " + e.getMessage());
        }

        return null;
    }

    private static Object rowToObject(String[] row) {
        return new Object(row[0], row[1], Long.parseLong(row[2]), Long.parseLong(row[3]));
    }
}
