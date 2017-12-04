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
	public List<RoomInfo> list(@Param("orderBy") String orderBy){
		System.out.println(orderBy);
		return roomInfoService.roomList(Integer.parseInt(orderBy));
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
	 * 방 정보 조회
	 */
	@RequestMapping(value = "findById", method = RequestMethod.GET)
	public RoomInfo findById(@Param("id") int id) {
		return roomInfoService.findById(id);
	}
	
	/*
	 * 방의 정보 수정
	 * (유저가 들락날락 할때 카운트, 어웨이 수정, 레벨 수정)
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public RoomInfo update(@RequestBody RoomInfo roomInfo) {
		return roomInfoService.update(roomInfo);
	}
	
	/*
	 * 방에 대기인원이 없을 시 삭제(방장이 나갈 시)
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public int delete(@Param("id") int id) {
		return roomInfoService.delete(id);
	}
	
}
