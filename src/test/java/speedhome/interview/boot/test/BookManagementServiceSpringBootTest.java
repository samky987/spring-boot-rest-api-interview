package speedhome.interview.boot.test;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import speedhome.interview.boot.LibaryManagement.Repository.BookManagementRepository;
import speedhome.interview.boot.LibaryManagement.Service.BookManagementService;
import speedhome.interview.boot.LibaryManagement.Modal.Book;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BookManagementServiceSpringBootTest {

    @Autowired
    private BookManagementService bookManagementService;


    @Test
    public void testAddOrUpdateBook()
    {
        Book book = new Book("24234234234","How to win friends");
        bookManagementService.addOrUpdateBook(book);
        Book bookFromService = bookManagementService.getBook(book.getId());
        assertEquals(book.getBookName(),bookFromService.getBookName());
    }

    @Test
    public void testDeleteBook()
    {
        Book book = new Book("24234234234","How to win friends");
        bookManagementService.addOrUpdateBook(book);
        long bookId = book.getId();
        bookManagementService.deleteBook(bookId);
        assertThrows(NoSuchElementException.class,() ->
        {
            bookManagementService.getBook(bookId);
        });
    }

    @Test
    public void testGetBook() {
        Book book = new Book("24234234234","How to win friends");
        bookManagementService.addOrUpdateBook(book);
        long bookId = 1;
        Book result = bookManagementService.getBook(bookId);
        assertNotNull(result);
    }
}
