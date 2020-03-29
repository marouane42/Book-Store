package org.book.store.service;

import org.book.store.data.DataManager;
import org.book.store.pojo.Book;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("/books")
public class BookService {
    private DataManager dataManager = DataManager.getInstance();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Book> findBooks() { 
        return dataManager.getAllBooks();
    }

    @GET
    @Path("/{isbn}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findBook(@PathParam("isbn") String isbn) { 
        final Book book = dataManager.getBook(isbn);
        if (book == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.status(Response.Status.OK)
                .entity(book).build();
    }
}
