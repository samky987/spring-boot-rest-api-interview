package speedhome.interview.boot.LibaryManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import speedhome.interview.boot.LibaryManagement.Modal.Member;
import speedhome.interview.boot.LibaryManagement.Repository.MemberManagementRepository;

@Service
public class MemberManagementService
{
    @Autowired
    MemberManagementRepository memberManagementRepository;
    public void addOrUpdateMember(Member member)
    {
        member = memberManagementRepository.save(member);
    }
    public void deleteMember(long id)
    {
        memberManagementRepository.deleteById(id);
    }
    public Member getMember (long id)
    {
        Member member = memberManagementRepository.findById(id).get();
        return member;
    }
}
