package org.ulkhnv.service;

import org.ulkhnv.model.Object;

import java.math.BigInteger;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ObjectService {

    private final List<Object> objects;

    public ObjectService(List<Object> objects) {
        this.objects = objects;
    }

    public Map<String, Integer> findDuplicatesByGroupAndType() {
        return objects.stream()
                .collect(Collectors.toMap(
                        object -> object.getGroup() + " / " + object.getType(),
                        object -> 1,
                        Integer::sum));
    }

    public Map<String, BigInteger> findTotalWeightsByGroup() {
        return objects.stream()
                .collect(Collectors.groupingBy(Object::getGroup,
                        Collectors.reducing(BigInteger.ZERO, obj -> BigInteger.valueOf(obj.getWeight()), BigInteger::add)));
    }

    public long findMinWeightInObjects() {
        return Collections.min(objects, Comparator.comparing(Object::getWeight)).getWeight();
    }

    public long findMaxWeightInObjects() {
        return Collections.max(objects, Comparator.comparing(Object::getWeight)).getWeight();
    }
}
