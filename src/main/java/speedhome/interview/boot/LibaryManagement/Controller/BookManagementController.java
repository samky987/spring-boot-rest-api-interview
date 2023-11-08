package speedhome.interview.boot.LibaryManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import speedhome.interview.boot.LibaryManagement.Service.BookManagementService;
import speedhome.interview.boot.LibaryManagement.Modal.Book;

@RestController
@RequestMapping("book-management")
public class BookManagementController {
    @Autowired
    BookManagementService bookManagementService;
    @PostMapping("add-book")
    public ResponseEntity<String> addBook(@RequestBody Book book)
    {
        bookManagementService.addOrUpdateBook(book);
        System.out.println("Book : " + book.getBookName());
        return ResponseEntity.ok("Book created successfully");
    }
    @PostMapping("update-book")
    public ResponseEntity<String> updateBook (@RequestBody Book book)
    {
        bookManagementService.addOrUpdateBook(book);
        System.out.println("Book : " + book.getBookName());
        return ResponseEntity.ok("Book modified successfully");
    }
    @DeleteMapping("delete-book")
    public ResponseEntity<String> deleteBook(@RequestParam long id)
    {
        bookManagementService.deleteBook(id);
        return ResponseEntity.ok("Book delete successfully");
    }
    @GetMapping("get-book/{id}")
    public Book getBook (@PathVariable int id)
    {
        Book book = bookManagementService.getBook(id);
        return book;
    }
}
