package net.skhu.service;

import java.util.List;

import net.skhu.dto.RoomInfo;

public interface RoomInfoService {

	public List<RoomInfo> roomList();
	public List<RoomInfo> roomListwithLevel(int level);
	public List<RoomInfo> roomListwithUserCount(int userCount);
	public int create(RoomInfo roomInfo);
	public int update(RoomInfo roomInfo);
	public int delete(int id);
 }
