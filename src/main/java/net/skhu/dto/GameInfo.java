package net.skhu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude= {"inputNum", "orderUserId", "resultCount"})
@JsonPropertyOrder({"id", "roomId", "hostNumber", "awayNumber", "inputNum", "orderUserId", "resultCount"})
public class GameInfo {

	@JsonProperty("id") @JsonSerialize(using = ToStringSerializer.class)
	int id;
	@JsonProperty("roomId") @JsonSerialize(using = ToStringSerializer.class)
	int roomId;
	@JsonProperty("hostNumber")
	String hostNumber;
	@JsonProperty("awayNumber")
	String awayNumber;
	@JsonProperty("inputNum")
	String inputNum;
	@JsonProperty("orderUserId") @JsonSerialize(using = ToStringSerializer.class)
	int orderUserId;
	@JsonProperty("resultCount")
	String resultCount;
	
}
