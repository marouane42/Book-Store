package org.book.store.pojo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Author extends GenericIdStringPojo {
    private static final AtomicInteger nextId = new AtomicInteger(0);
    private static final Map<String, Author> AUTHORS = new HashMap<>();
    private Author(String name) {
        super(nextId.incrementAndGet(), name);
    }

    public static Author getAuthor(String name) {
        return AUTHORS.computeIfAbsent(name, Author::new);
    }
}
