package org.book.store.pojo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Category extends GenericIdStringPojo {
    private static final AtomicInteger nextId = new AtomicInteger(0);
    private static final Map<String, Category> CATEGORIES = new HashMap<>();
    private Category(String name) {
        super(nextId.incrementAndGet(), name);
    }

    public static Category getCategory(String name) {
        return CATEGORIES.computeIfAbsent(name, Category::new);
    }
}
