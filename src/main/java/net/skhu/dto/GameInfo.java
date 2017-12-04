package net.skhu.dto;

import lombok.Data;

@Data
public class GameInfo {

	int id;
	int roomId;
	String hostNumber;
	String awayNumber;
	String inputNum;
	int orderUserId;
	BallCount hostCount;
	BallCount awayCount;
	
}
