package org.ulkhnv.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ulkhnv.model.Object;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ObjectServiceTest {

    private ObjectService objectService;

    @BeforeEach
    void setUpObjects() {
        Object object1 = new Object("testGroup1", "testType1", 1, 1);
        Object object2 = new Object("testGroup2", "testType2", 2, 2);
        Object object3 = new Object("testGroup2", "testType2", 3, 5);
        List<Object> objects = Arrays.asList(object1, object2, object3);
        objectService = new ObjectService(objects);

    }

    @Test
    void findDuplicatesByGroupAndType() {
        Map<String, Integer> expected = new HashMap<>();
        expected.put("testGroup1 / testType1", 1);
        expected.put("testGroup2 / testType2", 2);

        Map<String, Integer> actual = objectService.findDuplicatesByGroupAndType();

        Assertions.assertEquals(expected, actual);


    }

    @Test
    void findTotalWeightsByGroup() {
        Map<String, BigInteger> expected = new HashMap<>();
        expected.put("testGroup1", BigInteger.ONE);
        expected.put("testGroup2", BigInteger.valueOf(7));

        Map<String, BigInteger> actual = objectService.findTotalWeightsByGroup();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findMinWeightInObjects() {
        Assertions.assertEquals(1, objectService.findMinWeightInObjects());
    }

    @Test
    void findMaxWeightInObjects() {
        Assertions.assertEquals(5, objectService.findMaxWeightInObjects());
    }
}
