package model.DM0002;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Comment
 */
public class DM0002Request_Body {
	/**
	 * 종료 인덱스
	 */
	private Integer endIndex = null;
	/**
	 * 시작 인덱스
	 */
	private Integer startIndex = null;

	public DM0002Request_Body() {
	}

	public DM0002Request_Body(JsonNode jsonNode) {
		this.endIndex = jsonNode.path("endIndex").intValue();
		this.startIndex = jsonNode.path("startIndex").intValue();
	}

	@JsonProperty("endIndex")
	public Integer getEndIndex() {
		return this.endIndex;
	}

	public void setEndIndex(Integer endIndex) {
		this.endIndex = endIndex;
	}

	@JsonProperty("startIndex")
	public Integer getStartIndex() {
		return this.startIndex;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DM0002Request_Body [");
		builder.append("endIndex=").append(endIndex);
		builder.append(", ");
		builder.append("startIndex=").append(startIndex);
		builder.append("]");
		return builder.toString();
	}
}