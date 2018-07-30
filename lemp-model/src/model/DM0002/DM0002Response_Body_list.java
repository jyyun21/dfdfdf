package model.DM0002;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 게시판 목록
 */
public class DM0002Response_Body_list {
	/**
	 * 등록자명
	 */
	private String userName = "";
	/**
	 * 제목
	 */
	private String title = "";
	/**
	 * 등록일시(yyyyMMddhHmm)
	 */
	private String regDate = "";
	/**
	 * 부서명
	 */
	private String deptName = "";
	/**
	 * 문서 ID
	 */
	private Integer docId = null;

	public DM0002Response_Body_list() {
	}

	public DM0002Response_Body_list(JsonNode jsonNode) {
		this.userName = jsonNode.path("userName").textValue();
		this.title = jsonNode.path("title").textValue();
		this.regDate = jsonNode.path("regDate").textValue();
		this.deptName = jsonNode.path("deptName").textValue();
		this.docId = jsonNode.path("docId").intValue();
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

	@JsonProperty("deptName")
	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@JsonProperty("docId")
	public Integer getDocId() {
		return this.docId;
	}

	public void setDocId(Integer docId) {
		this.docId = docId;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DM0002Response_Body_list [");
		builder.append("userName=").append(userName);
		builder.append(", ");
		builder.append("title=").append(title);
		builder.append(", ");
		builder.append("regDate=").append(regDate);
		builder.append(", ");
		builder.append("deptName=").append(deptName);
		builder.append(", ");
		builder.append("docId=").append(docId);
		builder.append("]");
		return builder.toString();
	}
}