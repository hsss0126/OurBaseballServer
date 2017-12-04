package net.skhu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.skhu.dto.GameInfo;
import net.skhu.etc.ResponseCode;
import net.skhu.mapper.GameInfoMapper;

@Service("GameInfoService")
public class GameInfoServiceImpl {

	@Autowired GameInfoMapper gameInfoMapper;
	
	/*
	 * 방 생성 시 해당 방id를 통해 생성
	 */
	public GameInfo create(GameInfo gameInfo) {
		gameInfoMapper.insert(gameInfo);
		return gameInfoMapper.findByRoomId(gameInfo.getRoomId());
	}
	
	/*
	 * 게임 중 업데이트
	 */
	public GameInfo update(GameInfo gameInfo) {
		gameInfoMapper.update(gameInfo);
		return gameInfoMapper.findOne(gameInfo.getId());
	}
	/*
	 * 게임 시작 전 준비단계에서 숫자 입력 시 업데이트
	 */
	public GameInfo setting(GameInfo gameInfo) {
		gameInfoMapper.setting(gameInfo);
		return gameInfoMapper.findOne(gameInfo.getId());
	}
	/*
	 * 게임 끝난 후 정보를 초기화
	 */
	public GameInfo gameEnd(int id) {
		gameInfoMapper.gameEnd(id);
		return gameInfoMapper.findOne(id);
	}
	
	/*
	 * 해당 방의 게임정보를 조회
	 */
	public GameInfo findById(int id) {
		return gameInfoMapper.findOne(id);
	}
	
	/*
	 * 해당 방의 게임정보를 조회
	 */
	public GameInfo findByRoomId(int roomId) {
		return gameInfoMapper.findByRoomId(roomId);
	}
	
	/*
	 * 방 삭제 시 먼저 제거(GameInfo id)
	 */
	public int delete(int id) {
		gameInfoMapper.delete(id);
		return ResponseCode.gameInfo_delete_success;
	}
	
	/*
	 * 방 삭제 시 먼저 제거(roomId)
	 */
	public int deleteByRoomId(int roomId) {
		gameInfoMapper.deleteByRoomId(roomId);
		return ResponseCode.gameInfo_delete_success;
	}
}
