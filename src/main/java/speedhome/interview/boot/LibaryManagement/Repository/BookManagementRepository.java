package speedhome.interview.boot.LibaryManagement.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import speedhome.interview.boot.LibaryManagement.Modal.Book;

@Repository
public interface BookManagementRepository extends CrudRepository<Book, Long>
{
}
