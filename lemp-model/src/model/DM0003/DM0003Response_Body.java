package model.DM0003;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Comment
 */
public class DM0003Response_Body {
	/**
	 * 등록자명
	 */
	private String userName = "";
	/**
	 * 제목
	 */
	private String title = "";
	/**
	 * 등록일시(yyyyMMddHHmm)
	 */
	private String regDate = "";
	/**
	 * 본문
	 */
	private String contents = "";
	/**
	 * 부서명
	 */
	private String deptName = "";

	public DM0003Response_Body() {
	}

	public DM0003Response_Body(JsonNode jsonNode) {
		this.userName = jsonNode.path("userName").textValue();
		this.title = jsonNode.path("title").textValue();
		this.regDate = jsonNode.path("regDate").textValue();
		this.contents = jsonNode.path("contents").textValue();
		this.deptName = jsonNode.path("deptName").textValue();
	}

	@JsonProperty("userName")
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@JsonProperty("title")
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@JsonProperty("regDate")
	public String getRegDate() {
		return this.regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@JsonProperty("contents")
	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	@JsonProperty("deptName")
	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DM0003Response_Body [");
		builder.append("userName=").append(userName);
		builder.append(", ");
		builder.append("title=").append(title);
		builder.append(", ");
		builder.append("regDate=").append(regDate);
		builder.append(", ");
		builder.append("contents=").append(contents);
		builder.append(", ");
		builder.append("deptName=").append(deptName);
		builder.append("]");
		return builder.toString();
	}
}