package speedhome.interview.boot.LibaryManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import speedhome.interview.boot.LibaryManagement.Repository.BookManagementRepository;
import speedhome.interview.boot.LibaryManagement.Modal.Book;

@Service
public class BookManagementService
{
    @Autowired
    BookManagementRepository bookManagementRepository;
    public void addOrUpdateBook(Book book)
    {
        book = bookManagementRepository.save(book);
    }
    public void deleteBook(long id)
    {
        bookManagementRepository.deleteById(id);
    }
    public Book getBook (long id)
    {
        Book book = bookManagementRepository.findById(id).get();
        return book;
    }
}
