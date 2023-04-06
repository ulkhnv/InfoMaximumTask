package org.ulkhnv.model;

public class Object {

    private final String group;
    private final String type;
    private final long number;
    private final long weight;

    public Object(String group, String type, long number, long weight) {
        this.group = group;
        this.type = type;
        this.number = number;
        this.weight = weight;
    }

    public String getGroup() {
        return group;
    }

    public String getType() {
        return type;
    }

    public long getNumber() {
        return number;
    }

    public long getWeight() {
        return weight;
    }
}
