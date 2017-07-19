package louisz.springboot.example6;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, Long>{
	Member findById(Long id);
	Member findByName(String name);
    @Query("from Member u where u.name=:name")
    Member findMember(@Param("name") String name);    
    Member findByNameAndAge(String name, Integer age);
    Long countByName(String name);
}
