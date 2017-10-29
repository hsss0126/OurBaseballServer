package net.skhu.dto;

import lombok.Data;

@Data
public class RoomInfo {

	int id;
	String name;
	int hostId;
	String hostName;
	int awayId;
	String awayName;
	int level;
	int userCount;
	
}
