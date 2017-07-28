package louisz.springboot.example6;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, Long>{
	/**
	 * 使用ID查詢資料，並回傳Member Entity
	 * @param id
	 * @return
	 */
	Member findById(Long id);
	/**
	 * 使用ID查詢資料，並回傳Member Entity
	 * @param name
	 * @return
	 */
	Member findByName(String name);
	/**
	 * 透過JPQL，使用NAME查詢，並回傳Member Entity
	 * @param name
	 * @return
	 */
    @Query("from Member u where u.name=:name")
    Member findMember(@Param("name") String name);    
    /**
     * 使用NAME及AGE查詢，並回傳Member Entity
     * @param name
     * @param age
     * @return
     */
    Member findByNameAndAge(String name, Integer age);
    /**
     * 使用NAME進行Count，並回傳筆數
     * @param name
     * @return
     */
    Long countByName(String name);
    //不分姓名大小寫的查詢
    /**
     * 使用NAME進行查詢且不分大小寫，並回傳List<Member>
     * @param name
     * @return
     */
    List<Member> findByNameIgnoreCase(String name);	
}
