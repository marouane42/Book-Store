package org.book.store.pojo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Status extends GenericIdStringPojo {
    private static final AtomicInteger nextId = new AtomicInteger(0);
    private static final Map<String, Status> STATUSES = new HashMap<>();
    private Status(String name) {
        super(nextId.incrementAndGet(), name);
    }

    public static Status getStatus(String name) {
        return STATUSES.computeIfAbsent(name, Status::new);
    }


}
