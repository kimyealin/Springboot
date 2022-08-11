package yeling.spring.board.persistence;

import org.springframework.data.repository.CrudRepository;
import yeling.spring.board.domain.Member;

public interface MemberRepository extends CrudRepository<Member, String>{

}
