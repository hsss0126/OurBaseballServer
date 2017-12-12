package net.skhu.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.skhu.dto.GameInfo;
import net.skhu.service.GameInfoServiceImpl;

@RestController
@RequestMapping("gameInfo")
public class GameInfoController {

	@Autowired GameInfoServiceImpl gameInfoService;
	
	/*
	 * 방 생성 시 해당 방id를 통해 생성
	 */
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public GameInfo create(@Param("roomId") int roomId) {
		return gameInfoService.create(roomId);
	}
	
	/*
	 * 게임 중 업데이트
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public GameInfo update(@RequestBody GameInfo gameInfo) {
		return gameInfoService.update(gameInfo);
	}
	
	/*
	 * 게임 시작 전 준비단계에서 숫자 입력 시 업데이트
	 */
	@RequestMapping(value = "setting", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public GameInfo setting(@RequestBody GameInfo gameInfo) {
		return gameInfoService.setting(gameInfo);
	}
	
	/*
	 * 게임 끝난 후 정보를 초기화
	 */
	@RequestMapping(value = "gameEnd", method = RequestMethod.GET)
	public GameInfo gameEnd(@Param("id") int id) {
		return gameInfoService.gameEnd(id);
	}
	
	/*
	 * 해당 방의 게임정보를 조회
	 */
	@RequestMapping(value = "findById", method = RequestMethod.GET)
	public GameInfo findById(@Param("id") int id) {
		return gameInfoService.findById(id);
	}
	
	/*
	 * 해당 방의 게임정보를 조회
	 */
	@RequestMapping(value = "findByRoomId", method = RequestMethod.GET)
	public GameInfo findByRoomId(@Param("roomId") int roomId) {
		return gameInfoService.findByRoomId(roomId);
	}
	
	/*
	 * 방 삭제 시 먼저 제거(GameInfo id)
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public int delete(@Param("id") int id) {
		return gameInfoService.delete(id);
	}
	
	/*
	 * 방 삭제 시 먼저 제거(roomId)
	 */
	@RequestMapping(value = "deleteByRoomId", method = RequestMethod.GET)
	public int deleteByRoomId(@Param("roomId") int roomId) {
		return gameInfoService.deleteByRoomId(roomId);
	}
	
	
	
}
