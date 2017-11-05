package net.skhu.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.skhu.dto.RoomInfo;
import net.skhu.service.RoomInfoServiceImpl;

@RestController
@RequestMapping("roomInfo")
public class RoomInfoController {

	@Autowired RoomInfoServiceImpl roomInfoService;
	/*
	 * 현재 만들어진 방 목록 조회
	 */
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public List<RoomInfo> roomList(){
		return roomInfoService.roomList();
	}
	
	/*
	 * 사용자가 선택한 레벨의 방만 조회
	 */
	@RequestMapping(value = "roomListwithLevel", method = RequestMethod.GET)
	public List<RoomInfo> roomListwithLevel(@Param("level") int level){
		return roomInfoService.roomListwithLevel(level);
	}
	
	/*
	 * 접속 가능한 방만 조회
	 */
	@RequestMapping(value = "roomListwithUserCount", method = RequestMethod.GET)
	public List<RoomInfo> roomListwithUserCount(@Param("userCount") int userCount){
		return roomInfoService.roomListwithUserCount(userCount);
	}
	
	/*
	 * 방만들고 방의 정보를 추가
	 */
	@RequestMapping(value = "create", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public RoomInfo create(@RequestBody RoomInfo roomInfo) {
		System.out.println("컨트롤러 : "+roomInfo.toString());
		return roomInfoService.create(roomInfo);
	}
	
	/*
	 * 방의 정보 수정
	 * (유저가 들락날락 할때 카운트 수정, 레벨 수정, 호스트 수정)
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public int update(@RequestBody RoomInfo roomInfo) {
		return roomInfoService.update(roomInfo);
	}
	
	/*
	 * 방에 대기인원이 없을 시 삭제
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public int delete(@Param("id") int id) {
		return roomInfoService.delete(id);
	}
}
