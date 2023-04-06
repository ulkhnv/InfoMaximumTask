package org.ulkhnv.util;

public class ParserFactory {
    public static Parser createParser(String extension) {
        switch (extension) {
            case "json":
                return new JSONParser();
            case "csv":
                return new CSVParser();
            default:
                System.out.println("Unsupported format. Supported formats: [.json, .csv]");
                return null;
        }
    }
}