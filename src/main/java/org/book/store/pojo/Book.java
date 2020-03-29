package org.book.store.pojo;

import com.fasterxml.jackson.databind.JsonNode;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class Book {
    private String isbn;    // Supposed to be Number, but the json has String
    private String title;
    private Integer pageCount;
    private Long publishedDate;
    private String thumbnailUrl;
    private String shortDescription;
    private String longDescription;
    private Status status; // PUBLISH, MEAP
    private Set<Author> authors = new LinkedHashSet<>();
    private Set<Category> categories = new LinkedHashSet<>();

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Long getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(JsonNode publishedDate) {
        if (publishedDate != null) {
            final String publishDateStr = publishedDate.get("$date").asText();
            try {
                final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.ENGLISH);
                this.publishedDate = ZonedDateTime.parse(publishDateStr, dtf)
                        .toInstant().toEpochMilli();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(String statusName) {
        this.status = Status.getStatus(statusName);
    } 

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authorsNames) {
        this.authors.addAll(
                Arrays
                        .stream(authorsNames)
                        .map(Author::getAuthor)
                        .collect(Collectors.toList()));
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(String[] categoriesNames) {
        this.categories.addAll(
            Arrays
                .stream(categoriesNames)
                .map(Category::getCategory)
                .collect(Collectors.toList()));
    }
}