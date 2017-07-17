package louisz.springboot.example6;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "member")
public class Member {
	@Id
    @GeneratedValue
    @Setter @Getter
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    @Setter @Getter
    private Integer age;
}
