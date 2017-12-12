package net.skhu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.skhu.dto.BallCount;
import net.skhu.dto.GameInfo;
import net.skhu.dto.RoomInfo;
import net.skhu.etc.ResponseCode;
import net.skhu.mapper.GameInfoMapper;
import net.skhu.mapper.RoomInfoMapper;

@Service("GameInfoService")
public class GameInfoServiceImpl {

	@Autowired GameInfoMapper gameInfoMapper;
	@Autowired RoomInfoMapper roomInfoMapper;
	
	/*
	 * 방 생성 시 해당 방id를 통해 생성
	 */
	public GameInfo create(int roomId) {
		gameInfoMapper.insert(roomId);
		return gameInfoMapper.findByRoomId(roomId);
	}
	
	/*
	 * 게임 중 업데이트
	 * 볼카운트 계산 동반
	 */
	public GameInfo update(GameInfo gameInfo) {
		gameInfoMapper.update(gameInfo);
		GameInfo updatedGameInfo = gameInfoMapper.findOne(gameInfo.getId());
		RoomInfo roomInfo = roomInfoMapper.findOne(gameInfo.getRoomId());
		updatedGameInfo.setResultCount(checkBallCount(updatedGameInfo, roomInfo));
		return updatedGameInfo;
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
		GameInfo findInfo = gameInfoMapper.findOne(id);
		if(findInfo != null && findInfo.getInputNum() != null) {
			RoomInfo roomInfo = roomInfoMapper.findOne(findInfo.getRoomId());
			findInfo.setResultCount(checkBallCount(findInfo, roomInfo));
		}
		return findInfo;
	}
	
	/*
	 * 해당 방의 게임정보를 조회
	 */
	public GameInfo findByRoomId(int roomId) {
		GameInfo findInfo = gameInfoMapper.findByRoomId(roomId);
		if(findInfo.getInputNum() != null) {
			RoomInfo roomInfo = roomInfoMapper.findOne(roomId);
			findInfo.setResultCount(checkBallCount(findInfo, roomInfo));
		}
		return findInfo;
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
	
	public String checkBallCount(GameInfo gameInfo, RoomInfo roomInfo) {
		BallCount count = new BallCount();
		char[] inputNum = gameInfo.getInputNum().toCharArray();
//		System.out.println("입력한 숫자:"+Arrays.toString(inputNum));
		char[] checkNum;
		if(gameInfo.getOrderUserId() == roomInfo.getHostId()) {
			checkNum = gameInfo.getAwayNumber().toCharArray();
//			System.out.println("host가 입력 - away의 숫자:"+Arrays.toString(checkNum));
		} else {
			checkNum = gameInfo.getHostNumber().toCharArray();
//			System.out.println("away가 입력 - host의 숫자:"+Arrays.toString(checkNum));
		}
		
		for(int i=0; i<roomInfo.getLevel(); i++) {
//			System.out.println(i +" : " + checkNum[i] + " : " + inputNum[i]);
			if(checkNum[i] == inputNum[i]) {
//				System.out.println("스트라이크+1");
				count.setStrike(count.getStrike()+1);
			} else if(duplicateCheck(checkNum, inputNum[i])) {
//				System.out.println("볼 +1");
				count.setBall(count.getBall()+1);
			}
		}
//		System.out.println(count.toString());
		return count.toString();
	}
	
	public Boolean duplicateCheck(char[] checkNum, char input) {
		for (int i = 0; i < checkNum.length; i++) {
			if (checkNum[i] == input) {
				return true;
			}
		}
		return false;
	}
}
