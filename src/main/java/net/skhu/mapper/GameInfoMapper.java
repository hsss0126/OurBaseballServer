package net.skhu.mapper;

import org.apache.ibatis.annotations.Mapper;

import net.skhu.dto.GameInfo;

@Mapper
public interface GameInfoMapper {

	GameInfo findOne(int id);
	GameInfo findByRoomId(int roomId);
	void insert(GameInfo gameInfo);
	void update(GameInfo gameInfo);
	void setting(GameInfo gameInfo);
	void gameEnd(int id);
	void delete(int id);
	void deleteByRoomId(int roomId);
	
}
