package net.skhu.service;

import net.skhu.dto.GameInfo;

public interface GameInfoService {

	public GameInfo findById(int id);
	public GameInfo findByRoomId(int roomId);
	public GameInfo create(GameInfo gameInfo);
	public GameInfo update(GameInfo gameInfo);
	public GameInfo setting(GameInfo gameInfo);
	public GameInfo gameEnd(GameInfo gameInfo);
	public int delete(int id);
	public int deleteByRoomId(int roomId);
}
