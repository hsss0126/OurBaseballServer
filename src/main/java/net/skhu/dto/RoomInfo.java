package net.skhu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import lombok.Data;

@Data
@JsonPropertyOrder({"id", "roomName", "hostId", "hostName", "awayId", "awayName", "level", "userCount"})
public class RoomInfo {

	@JsonProperty("id") @JsonSerialize(using = ToStringSerializer.class)
	int id;
	@JsonProperty("roomName")
	String roomName;
	@JsonProperty("hostId") @JsonSerialize(using = ToStringSerializer.class)
	int hostId;
	@JsonProperty("hostName")
	String hostName;
	@JsonProperty("awayId") @JsonSerialize(using = ToStringSerializer.class)
	int awayId;
	@JsonProperty("awayName")
	String awayName;
	@JsonProperty("level") @JsonSerialize(using = ToStringSerializer.class)
	int level;
	@JsonProperty("userCount") @JsonSerialize(using = ToStringSerializer.class)
	int userCount;
	
}
