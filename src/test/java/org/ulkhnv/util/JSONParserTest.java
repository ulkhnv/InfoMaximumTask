package org.ulkhnv.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.ulkhnv.model.Object;

import java.util.List;

class JSONParserTest {

    @Test
    void parse() {
        Parser parser = new JSONParser();
        String filePath = "src/test/resources/test.json";
        List<Object> result = parser.parse(filePath);
        Assertions.assertNotNull(result, "The result must not be null");
        Assertions.assertEquals(3, result.size(), "The list of objects must contain 3 elements");

    }
}
