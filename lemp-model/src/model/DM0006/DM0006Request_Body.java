package model.DM0006;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Comment
 */
public class DM0006Request_Body {
	/**
	 * 제목
	 */
	private String title = "";
	/**
	 * 본문
	 */
	private String contents = "";
	/**
	 * 문서 ID
	 */
	private Integer docId = null;

	public DM0006Request_Body() {
	}

	public DM0006Request_Body(JsonNode jsonNode) {
		this.title = jsonNode.path("title").textValue();
		this.contents = jsonNode.path("contents").textValue();
		this.docId = jsonNode.path("docId").intValue();
	}

	@JsonProperty("title")
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@JsonProperty("contents")
	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
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
		builder.append("DM0006Request_Body [");
		builder.append("title=").append(title);
		builder.append(", ");
		builder.append("contents=").append(contents);
		builder.append(", ");
		builder.append("docId=").append(docId);
		builder.append("]");
		return builder.toString();
	}
}