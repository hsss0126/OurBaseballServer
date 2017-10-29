package net.skhu.mapper;

import org.apache.ibatis.annotations.Mapper;

import net.skhu.dto.GameInfo;

@Mapper
public interface GameInfoMapper {

	GameInfo findOne(int id);
	void insert(GameInfo gameInfo);
	void update(GameInfo gameInfo);
	void delete(int id);
	
}
