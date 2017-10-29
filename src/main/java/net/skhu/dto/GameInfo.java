package net.skhu.dto;

import lombok.Data;

@Data
public class GameInfo {

	int id;
	int roomId;
	int hostNumber;
	int awayNumber;
	int inputNum;
	int orderUserId;
	BallCount hostCount;
	BallCount awayCount;
	
}
