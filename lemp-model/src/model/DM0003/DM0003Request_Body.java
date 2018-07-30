package model.DM0003;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Comment
 */
public class DM0003Request_Body {
	/**
	 * 문서 ID
	 */
	private Integer docId = null;

	public DM0003Request_Body() {
	}

	public DM0003Request_Body(JsonNode jsonNode) {
		this.docId = jsonNode.path("docId").intValue();
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
		builder.append("DM0003Request_Body [");
		builder.append("docId=").append(docId);
		builder.append("]");
		return builder.toString();
	}
}