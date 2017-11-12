package net.skhu.service;

import java.util.List;

import net.skhu.dto.RoomInfo;

public interface RoomInfoService {

	public List<RoomInfo> roomList(int orderBy);
	public RoomInfo create(RoomInfo roomInfo);
	public RoomInfo update(RoomInfo roomInfo);
	public int delete(int id);
 }
