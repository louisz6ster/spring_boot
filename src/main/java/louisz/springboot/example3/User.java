package louisz.springboot.example3;

import io.swagger.annotations.ApiModelProperty;

public class User {
	@ApiModelProperty(notes = "ID", required = true)
	private Long id;
	@ApiModelProperty(notes = "使用者姓名", required = true)
	private String name;
	@ApiModelProperty(notes = "使用者emai", required = true)
	private String email;
	@ApiModelProperty(notes = "使用者手機號碼")
	private String mobilenumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	

}
