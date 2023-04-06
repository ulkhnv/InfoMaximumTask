package org.ulkhnv.util;

import org.ulkhnv.model.Object;

import java.util.List;

public interface Parser {

    List<Object> parse(String filePath);
}
