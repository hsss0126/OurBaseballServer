package net.skhu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.skhu.dto.User;
import net.skhu.etc.ResponseCode;
import net.skhu.mapper.UserMapper;

@Service("UserService")
public class UserServiceImpl {
	
	@Autowired UserMapper userMapper;

	/*
	 * 로그인 할때, 중복확인 할때 닉네임을 통해 유저 정보 받아오기(접속 상태 수정)
	 * 중복확인 시에는 반환되는 정보가 있으면 중복
	 */
	public int login(User user) {
		System.out.println(user.toString());
		User storedUser = userMapper.findOnebyNickName(user.getNickName());
		//해당 닉네임을 가진 데이터가 존재한다면
		if(storedUser != null) {
			System.out.println(storedUser.toString());
			if(storedUser.getPassword().equals(user.getPassword())) {
				System.out.println("패스워드 동일 접속상태로 변경 시도");
				storedUser.setStateId("1");
				System.out.println("접속상태 세팅");
				userMapper.update(storedUser);
				System.out.println("업데이트 완료 후 리턴");
				return ResponseCode.user_login_success;
			} else {
				return ResponseCode.user_pwd_error;
			}
		} else {
			return ResponseCode.user_id_error;
		}
	}
	
	/*
	 * user정보 업데이트
	 * 접속 상태 나 승패관련 정보
	 */
	public int update(User user) {
		userMapper.update(user);
		return ResponseCode.user_update_success;
	}
	
	/*
	 * 가입 시 유저 목록에 추가
	 */
	public int create(User user) {
		userMapper.insert(user);
		return ResponseCode.user_create_success;
	}
	/*
	 * 아이디를 통해 유저 정보 받아오기 (내정보 or 상대정보)
	 */
	public User infobyId(int id) {
		User user = userMapper.findOne(id);
		return user;
	}
	/*
	 * 닉네임을 통해 유저 정보 받아오기 (내정보 or 상대정보)
	 */
	public User infobyNickName(String nickName) {
		User user = userMapper.findOnebyNickName(nickName);
		return user;
	}
	
	/*
	 * 현재 접속중인 유저 받아오기
	 */
	public List<User> list(){
		List<User> users = userMapper.findAllbyState();
		return users;
	}
	
	/*
	 * 유저 id로 삭제
	 */
	public int delete(int id) {
		userMapper.delete(id);
		return ResponseCode.user_delete_success;
	}

}
