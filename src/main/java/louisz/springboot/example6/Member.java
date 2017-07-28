package louisz.springboot.example6;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity//Entity宣告
@Table(name = "member")//指定對應Table，請記得一定要有ID欄位(名稱可以改變)作為PK喔
public class Member {
	@Id //PK
    @GeneratedValue //之後針對SEQUENCE會需要
    @Setter @Getter //lombok 減少setter及getter method撰寫
    private Long id;
    @Column(nullable = false)//不可為空值
    @Setter @Getter
    private String name;
    @Column(nullable = false)
    @Setter @Getter
    private Integer age;
}
