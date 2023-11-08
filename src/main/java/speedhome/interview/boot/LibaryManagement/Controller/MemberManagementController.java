package speedhome.interview.boot.LibaryManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import speedhome.interview.boot.LibaryManagement.Modal.Member;
import speedhome.interview.boot.LibaryManagement.Service.MemberManagementService;

@RestController
@RequestMapping("member-management")
public class MemberManagementController
{
    @Autowired
    MemberManagementService memberManagementService;
    @PostMapping("add-member")
    public ResponseEntity<String> addMember(@RequestBody Member member)
    {
        memberManagementService.addOrUpdateMember(member);
        System.out.println("Member : " + member.getName());
        return ResponseEntity.ok("Member created successfully");
    }
    @PostMapping("update-member")
    public ResponseEntity<String> updateMember (@RequestBody Member member)
    {
        memberManagementService.addOrUpdateMember(member);
        System.out.println("Member : " + member.getName());
        return ResponseEntity.ok("Member modified successfully");
    }
    @DeleteMapping("delete-member")
    public ResponseEntity<String> deleteMember(@RequestParam long id)
    {
        memberManagementService.deleteMember(id);
        return ResponseEntity.ok("Member delete successfully");
    }
    @GetMapping("get-member/{id}")
    public Member getMember(@PathVariable int id)
    {
        Member member = memberManagementService.getMember(id);
        return member;
    }
}
