package speedhome.interview.boot.LibaryManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import speedhome.interview.boot.LibaryManagement.Modal.Book;
import speedhome.interview.boot.LibaryManagement.Modal.Member;
import speedhome.interview.boot.LibaryManagement.Repository.BookManagementRepository;
import speedhome.interview.boot.LibaryManagement.Repository.MemberManagementRepository;

@Service
public class MemberService
{
    @Autowired
    private BookManagementRepository bookManagementRepository;
    @Autowired
    private MemberManagementRepository memberManagementRepository;
    public boolean borrowBook (long memberId, long bookId)
    {
        Book book = bookManagementRepository.findById(bookId).get();
        Member member = memberManagementRepository.findById(memberId).get();

        if (book.getBorrower() == null)
        {
            book.setBorrower(member);
            bookManagementRepository.save(book);
            return true;
        }
        else
            return false;
    }
    public boolean returnBook (long memberId, long bookId)
    {
        Book book = bookManagementRepository.findById(bookId).get();
        Member member = memberManagementRepository.findById(memberId).get();

        if (book.getBorrower() != null)
        {
            book.setBorrower(null);
            bookManagementRepository.save(book);
            return true;
        }
        else
            return false;
    }
    public boolean deleteMember (long memberId)
    {
        try
        {
            memberManagementRepository.deleteById(memberId);
            return true;
        }
        catch(EmptyResultDataAccessException exception)
        {
            return false;
        }
    }
}
