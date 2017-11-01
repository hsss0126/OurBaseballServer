package net.skhu.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import lombok.Data;

@Data
@JsonPropertyOrder({"id", "nickName", "password", "win", "lose", "stateId"})
public class User {

	@JsonProperty("id") @JsonSerialize(using = ToStringSerializer.class)
	int id;
	@JsonProperty("nickName")
	String nickName;
	@JsonProperty("password")
	String password;
	@JsonProperty("win") @JsonSerialize(using = ToStringSerializer.class)
	int win;
	@JsonProperty("lose") @JsonSerialize(using = ToStringSerializer.class)
	int lose;
	
	@JsonProperty("stateId") @JsonSerialize(using = ToStringSerializer.class)
	@JsonIgnore
	int stateId;
	@JsonProperty("stateName")
	String stateName;
	
	
	
}
