package model.DM0006;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.co.ldcc.lemp.hybrid.common.server.JsonAdaptorObject;
import model.header.DMheader;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 게시물 수정
게시물을 수정한다.
 */
public class DM0006Request {
	/**
	 * header object
	 */
	private DMheader header = null;
	/**
	 * body object
	 */
	private DM0006Request_Body body = null;

	public DM0006Request() {
	}

	public DM0006Request(JsonAdaptorObject obj) {
		JsonNode rootNode = obj.get(JsonAdaptorObject.TYPE.REQUEST);
		JsonNode headerNode = rootNode.path("header");
		this.header = new DMheader(headerNode);
		JsonNode bodyNode = rootNode.path("body");
		this.body = new DM0006Request_Body(bodyNode);
	}

	@JsonProperty("header")
	public DMheader getHeader() {
		return this.header;
	}

	public void setHeader(DMheader header) {
		this.header = header;
	}

	@JsonProperty("body")
	public DM0006Request_Body getBody() {
		return this.body;
	}

	public void setBody(DM0006Request_Body body) {
		this.body = body;
	}

	public JsonNode toJsonNode() {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.valueToTree(this);
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DM0006Request [");
		builder.append("header=").append(header);
		builder.append(", ");
		builder.append("body=").append(body);
		builder.append("]");
		return builder.toString();
	}
}