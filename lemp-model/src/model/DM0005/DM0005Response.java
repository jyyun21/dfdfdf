package model.DM0005;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.co.ldcc.lemp.hybrid.common.server.JsonAdaptorObject;
import model.header.DMheader;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 게시판 삭제
게시판을 삭제한다.
 */
public class DM0005Response {
	/**
	 * header object
	 */
	private DMheader header = null;
	/**
	 * body object
	 */
	private DM0005Response_Body body = null;

	public DM0005Response() {
	}

	public DM0005Response(JsonAdaptorObject obj) {
		JsonNode rootNode = obj.get(JsonAdaptorObject.TYPE.RESPONSE);
		JsonNode headerNode = rootNode.path("header");
		this.header = new DMheader(headerNode);
		JsonNode bodyNode = rootNode.path("body");
		this.body = new DM0005Response_Body(bodyNode);
	}

	@JsonProperty("header")
	public DMheader getHeader() {
		return this.header;
	}

	public void setHeader(DMheader header) {
		this.header = header;
	}

	@JsonProperty("body")
	public DM0005Response_Body getBody() {
		return this.body;
	}

	public void setBody(DM0005Response_Body body) {
		this.body = body;
	}

	public JsonNode toJsonNode() {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.valueToTree(this);
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DM0005Response [");
		builder.append("header=").append(header);
		builder.append(", ");
		builder.append("body=").append(body);
		builder.append("]");
		return builder.toString();
	}
}