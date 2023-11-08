package speedhome.interview.boot.LibaryManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import speedhome.interview.boot.LibaryManagement.Service.MemberService;

@RestController
@RequestMapping("member")
public class MemberController
{
    @Autowired
    private MemberService memberService;
    @PostMapping("{memberId}/borrow/{bookId}")
    public ResponseEntity<String> borrowBook(@PathVariable long memberId, @PathVariable long bookId)
    {
        boolean status = memberService.borrowBook(memberId,bookId);
        if (status)
            return ResponseEntity.ok("Book status changed to borrowed");
        else
            return ResponseEntity.badRequest().build();
    }

    @PutMapping("{memberId}/return/{bookId}")
    public ResponseEntity<String> returnBook(@PathVariable Long memberId, @PathVariable Long bookId) {
        boolean status = memberService.returnBook(memberId,bookId);
        if (status)
            return ResponseEntity.ok("Book status changed to available");
        else
            return ResponseEntity.badRequest().build();
    }
    @DeleteMapping("delete/{memberId}")
    public ResponseEntity<String> deleteMember(@PathVariable long memberId)
    {
        boolean status = memberService.deleteMember(memberId);
        if(status)
            return ResponseEntity.ok("Member is deleted successfully");
        else
            return ResponseEntity.badRequest().build();
    }
}