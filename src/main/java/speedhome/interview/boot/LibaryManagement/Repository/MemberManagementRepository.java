package speedhome.interview.boot.LibaryManagement.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import speedhome.interview.boot.LibaryManagement.Modal.Member;

@Repository
public interface MemberManagementRepository extends CrudRepository<Member, Long>
{ }
