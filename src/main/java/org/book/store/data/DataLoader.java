package org.book.store.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.book.store.pojo.Book;

import java.io.IOException;
import java.util.List;

public class DataLoader {
    static List<Book> loadData() {
        try {
            final ObjectMapper objectMapper = new ObjectMapper();

            return objectMapper.readValue(
                    Thread.currentThread().getContextClassLoader().getResourceAsStream("data/books.json"),
                    new TypeReference<>() {
                    });
        } catch (IOException ex) {
            throw new RuntimeException("Could not read books from data/books.json");
        }
    }
}
