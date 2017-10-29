package net.skhu.dto;

import lombok.Data;

@Data
public class User {

	int id;
	String nickName;
	String password;
	int stateId;
	int win;
	int lose;	
	
}
