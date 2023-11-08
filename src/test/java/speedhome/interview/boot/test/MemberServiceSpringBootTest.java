package speedhome.interview.boot.test;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import speedhome.interview.boot.LibaryManagement.Modal.Book;
import speedhome.interview.boot.LibaryManagement.Modal.Member;
import speedhome.interview.boot.LibaryManagement.Repository.BookManagementRepository;
import speedhome.interview.boot.LibaryManagement.Repository.MemberManagementRepository;
import speedhome.interview.boot.LibaryManagement.Service.BookManagementService;
import speedhome.interview.boot.LibaryManagement.Service.MemberManagementService;
import speedhome.interview.boot.LibaryManagement.Service.MemberService;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MemberServiceSpringBootTest
{

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberManagementService memberManagementService;

    @Autowired
    private BookManagementService bookManagementService;

    private Member member;
    private Book book;
    @BeforeAll
    public void setup()
    {
        member = new Member();
        member.setName("Thomas Kon");
        book = new Book("24234234234","How to win friends");
        memberManagementService.addOrUpdateMember(member);
        bookManagementService.addOrUpdateBook(book);
    }
    @Test
    public void testBorrowBook()
    {
        memberService.borrowBook(member.getId(), book.getId());
        assertNotNull(book.getBorrower());
    }

    @Test
    public void testReturnBook()
    {
        book.setBorrower(member);
        bookManagementService.addOrUpdateBook(book);
        memberService.returnBook(member.getId(), book.getId());
        assertNull(member.getBorrowedBooks());
    }
}
