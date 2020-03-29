package org.book.store.data;

import org.book.store.pojo.Book;

import javax.inject.Named;
import java.util.*;

@Named
public class DataManager {
    private final Map<String, Book> books = new LinkedHashMap<>();
    private static final DataManager instance = new DataManager();

    static {
        DataLoader.loadData()
                .stream()
                .sorted(Comparator.comparing(Book::getTitle))
                .forEach(book -> instance.books.put(book.getIsbn(), book));
    }

    private DataManager() {}

    public static DataManager getInstance() {
        return instance;
    }
    
    public Collection<Book> getAllBooks() {
        return books.values();
    }

    public Book getBook(String isbn) {
        return books.get(isbn);
    }

}
