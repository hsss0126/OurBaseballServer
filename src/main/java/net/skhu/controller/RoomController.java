package net.skhu.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.skhu.dto.RoomInfo;
import net.skhu.mapper.GameInfoMapper;
import net.skhu.mapper.RoomInfoMapper;
import net.skhu.mapper.UserMapper;

@RestController
@RequestMapping("roomInfo")
public class RoomController {

	@Autowired UserMapper userMapper;
	@Autowired RoomInfoMapper roomInfoMapper;
	@Autowired GameInfoMapper gameInfoMapper;
	String result = "ok";
	
	/*
	 * 현재 만들어진 방 목록 조회
	 */
	@RequestMapping("roomList")
	public List<RoomInfo> roomList(){
		List<RoomInfo> rooms = roomInfoMapper.findAll();
		return rooms;
	}
	
	/*
	 * 사용자가 선택한 레벨의 방만 조회
	 */
	@RequestMapping(value = "roomListwithLevel", method = RequestMethod.GET)
	public List<RoomInfo> roomListwithLevel(@Param("level") int level){
		List<RoomInfo> rooms = roomInfoMapper.findAllwithLevel(level);
		return rooms;
	}
	
	/*
	 * 접속 가능한 방만 조회
	 */
	@RequestMapping(value = "roomListwithUserCount", method = RequestMethod.GET)
	public List<RoomInfo> roomListwithUserCount(@Param("count") int count){
		List<RoomInfo> rooms = roomInfoMapper.findAllwithUserCount(count);
		return rooms;
	}
	
	/*
	 * 방만들고 방의 정보를 추가
	 */
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String create(RoomInfo roomInfo) {
		roomInfoMapper.insert(roomInfo);
		return result;
	}
	
	/*
	 * 방의 정보 수정
	 * (유저가 들락날락 할때 카운트 수정, 레벨 수정, 호스트 수정)
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(RoomInfo roomInfo) {
		roomInfoMapper.update(roomInfo);
		return result;
	}
	
	/*
	 * 방에 대기인원이 없을 시 삭제
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(@Param("id") int id) {
		roomInfoMapper.delete(id);
		return result;
	}
}
