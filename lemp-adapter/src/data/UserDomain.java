package data;

public class UserDomain {

	/**
	 * 사용자 ID
	 */
	private String userId = "";
	
	/**
	 * 사용자 패스워드
	 */
	private String password = "";
	
	/**
	 * 사용자명
	 */
	private String userName = "";
	
	/**
	 * 전화번호
	 */
	private String tel = "";
	
	/**
	 * 휴대폰번호
	 */
	private String celTel = "";
	
	/**
	 * 이메일
	 */
	private String email = "";
	
	/**
	 * 부서명
	 */
	private String deptName = "";

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCelTel() {
		return celTel;
	}

	public void setCelTel(String celTel) {
		this.celTel = celTel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
}
