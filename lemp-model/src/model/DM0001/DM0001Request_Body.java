package model.DM0001;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Comment
 */
public class DM0001Request_Body {
	/**
	 * password
	 */
	private String password = "";
	/**
	 * userId
	 */
	private String userId = "";

	public DM0001Request_Body() {
	}

	public DM0001Request_Body(JsonNode jsonNode) {
		this.password = jsonNode.path("password").textValue();
		this.userId = jsonNode.path("userId").textValue();
	}

	@JsonProperty("password")
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@JsonProperty("userId")
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DM0001Request_Body [");
		builder.append("password=").append(password);
		builder.append(", ");
		builder.append("userId=").append(userId);
		builder.append("]");
		return builder.toString();
	}
}