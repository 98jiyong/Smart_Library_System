package DTO;

public class UserDto {
	private String id = null;
	private String name = null;
	private String pw = null;
	private String pwHint = null;
	private String tel = null;
	private String auth = null;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPwHint() {
		return pwHint;
	}
	public void setPwHint(String pwHint) {
		this.pwHint = pwHint;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", name=" + name + ", pw=" + pw + ", pwHint=" + pwHint + ", tel=" + tel + ", auth="
				+ auth + "]";
	}
	

}
