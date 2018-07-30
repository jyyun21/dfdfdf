package model.DM0002;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.co.ldcc.lemp.hybrid.common.server.JsonAdaptorObject;
import model.header.DMheader;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 게시판목록 조회
게시판 목록을 조회한다.
 */
public class DM0002Request {
	/**
	 * header object
	 */
	private DMheader header = null;
	/**
	 * body object
	 */
	private DM0002Request_Body body = null;

	public DM0002Request() {
	}

	public DM0002Request(JsonAdaptorObject obj) {
		JsonNode rootNode = obj.get(JsonAdaptorObject.TYPE.REQUEST);
		JsonNode headerNode = rootNode.path("header");
		this.header = new DMheader(headerNode);
		JsonNode bodyNode = rootNode.path("body");
		this.body = new DM0002Request_Body(bodyNode);
	}

	@JsonProperty("header")
	public DMheader getHeader() {
		return this.header;
	}

	public void setHeader(DMheader header) {
		this.header = header;
	}

	@JsonProperty("body")
	public DM0002Request_Body getBody() {
		return this.body;
	}

	public void setBody(DM0002Request_Body body) {
		this.body = body;
	}

	public JsonNode toJsonNode() {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.valueToTree(this);
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DM0002Request [");
		builder.append("header=").append(header);
		builder.append(", ");
		builder.append("body=").append(body);
		builder.append("]");
		return builder.toString();
	}
}