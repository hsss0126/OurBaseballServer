package net.skhu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.skhu.dto.RoomInfo;
import net.skhu.etc.ResponseCode;
import net.skhu.mapper.RoomInfoMapper;

@Service("RoomInfoService")
public class RoomInfoServiceImpl {

	@Autowired RoomInfoMapper roomInfoMapper;
	
	/*
	 * 현재 만들어진 방 목록 조회
	 */
	public List<RoomInfo> roomList(int orderBy){
		String[] orderArray = {"id", "id DESC",
							"roomName, id", "roomName DESC, id",
							"level, userCount, id", "level DESC, userCount, id",
							"userCount, id", "userCount DESC, id"};
		List<RoomInfo> rooms = roomInfoMapper.findAll(orderArray[orderBy]);
		return rooms;
	}
	
	/*
	 * 방만들고 방의 정보를 추가
	 */
	public RoomInfo create(RoomInfo roomInfo) {
		roomInfoMapper.insert(roomInfo);
		RoomInfo created = roomInfoMapper.findOnewithHostId(roomInfo.getHostId());
		return created;
	}
	
	/*
	 * 방의 정보 수정
	 * (유저가 들락날락 할때 카운트 수정, 레벨 수정, 호스트 수정)
	 */
	public int update(RoomInfo roomInfo) {
		roomInfoMapper.update(roomInfo);
		return ResponseCode.roomInfo_update_success;
	}
	
	/*
	 * 방에 대기인원이 없을 시 삭제
	 */
	public int delete(int id) {
		roomInfoMapper.delete(id);
		return ResponseCode.roomInfo_delete_success;
	}
}
