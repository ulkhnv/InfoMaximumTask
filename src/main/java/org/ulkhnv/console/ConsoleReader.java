package org.ulkhnv.console;

import org.ulkhnv.model.Object;
import org.ulkhnv.service.ObjectService;
import org.ulkhnv.util.Parser;
import org.ulkhnv.util.ParserFactory;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ConsoleReader {

    private ObjectService objectService;

    public void read() {
        try (Scanner scanner = new Scanner(System.in)) {
            String filePath;
            while (true) {
                System.out.println("Enter file path or exit to quit:");
                filePath = scanner.nextLine();

                if (filePath.equals("exit")) {
                    System.out.println("You have exited the program");
                    break;
                }
                processFile(filePath);
            }
        }
    }

    private void processFile(String filePath) {
        String extension = getFileExtension(filePath);
        Parser parser = ParserFactory.createParser(extension);
        if (parser != null) {
            List<Object> objects = parser.parse(filePath);
            if (objects != null) {
                objectService = new ObjectService(objects);
                printStatistics();
            }
        }
    }

    private String getFileExtension(String filePath) {
        String extension = "";
        int i = filePath.lastIndexOf('.');
        if (i > 0) {
            extension = filePath.substring(i + 1);
        }
        return extension;
    }

    private void printStatistics() {
        for (Map.Entry<String, Integer> entry : objectService.findDuplicatesByGroupAndType().entrySet()) {
            System.out.println("Group and Type: " + entry.getKey() + ", Count: " + entry.getValue());
        }

        for (Map.Entry<String, BigInteger> entry : objectService.findTotalWeightsByGroup().entrySet()) {
            System.out.println("Group: " + entry.getKey() + ", Total weight: " + entry.getValue());
        }

        System.out.println("Minimum weight in group: " + objectService.findMinWeightInObjects());
        System.out.println("Maximum weight in group: " + objectService.findMaxWeightInObjects());
    }
}
