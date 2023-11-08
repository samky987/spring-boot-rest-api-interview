package speedhome.interview.boot.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import speedhome.interview.boot.LibaryManagement.Modal.Book;
import speedhome.interview.boot.LibaryManagement.Modal.Member;
import speedhome.interview.boot.LibaryManagement.Repository.BookManagementRepository;
import speedhome.interview.boot.LibaryManagement.Repository.MemberManagementRepository;
import speedhome.interview.boot.LibaryManagement.Service.BookManagementService;
import speedhome.interview.boot.LibaryManagement.Service.MemberManagementService;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MemberManagementServiceSpringBootTest
{

    @Autowired
    private MemberManagementService memberManagementService;

    @Test
    public void testAddOrUpdateMember()
    {
        Member member = new Member();
        member.setName("Thomas Kon");
        memberManagementService.addOrUpdateMember(member);
        Member memberFromService = memberManagementService.getMember(member.getId());
        assertEquals(member.getName(),memberFromService.getName());
    }

    @Test
    public void testDeleteMember()
    {
        Member member = new Member();
        member.setName("Thomas Kon");
        memberManagementService.deleteMember(1);
        assertThrows(NoSuchElementException.class, () -> memberManagementService.getMember(member.getId()));
    }

    @Test
    public void testGetMember() {
        Member member = new Member();
        member.setName("Thomas Kon");
        memberManagementService.addOrUpdateMember(member);
        Member result = memberManagementService.getMember(member.getId());
        assertNotNull(result);
    }
}
