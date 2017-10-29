package net.skhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.skhu.dto.GameInfo;
import net.skhu.dto.RoomInfo;
import net.skhu.mapper.GameInfoMapper;
import net.skhu.mapper.RoomInfoMapper;
import net.skhu.mapper.UserMapper;

@RestController
@RequestMapping("gameInfo")
public class GameInfoController {

	@Autowired UserMapper userMapper;
	@Autowired RoomInfoMapper roomInfoMapper;
	@Autowired GameInfoMapper gameInfoMapper;
	String result = "ok";
	
	/*
	 * 게임 시작 시 두 게이머가 입력한 숫자와 차례를 입력하여 생성
	 */
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String create(GameInfo gameInfo) {
		gameInfoMapper.insert(gameInfo);
		return result;
	}
	
	/*
	 * 게임 시작 후 숫자 입력 시 업데이트
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(GameInfo gameInfo) {
		RoomInfo roomInfo = roomInfoMapper.findOne(gameInfo.getRoomId());
		if(gameInfo.getOrderUserId() == roomInfo.getHostId()) {
			gameInfo.setOrderUserId(roomInfo.getAwayId());
		} else {
			gameInfo.setOrderUserId(roomInfo.getHostId());
		}
		gameInfoMapper.update(gameInfo);
		return result;
	}
	
	
}
