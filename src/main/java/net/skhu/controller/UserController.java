package net.skhu.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.skhu.dto.User;
import net.skhu.mapper.RoomInfoMapper;
import net.skhu.mapper.UserMapper;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired UserMapper userMapper;
	@Autowired RoomInfoMapper roomInfoMapper;
	String result = "ok";
	
	/*
	 * 로그인 할때, 중복확인 할때 닉네임을 통해 유저 정보 받아오기
	 * 중복확인 시에는 반환되는 정보가 있으면 중복
	 */
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public User login(@Param("nickName") String nickName) {
		User user = userMapper.findOnewithNickName(nickName);
		System.out.println(user.toString());
		return user;
	}
	
	/*
	 * user정보 업데이트
	 * 접속 상태 나 승패관련 정보
	 */
	@RequestMapping(value = "stateUpdate", method = RequestMethod.POST)
	public String stateUpdate(User user) {
		userMapper.update(user);
		return result;
	}
	
	/*
	 * 가입 시 유저 목록에 추가
	 */
	@RequestMapping(value = "userCreate", method = RequestMethod.POST)
	public String userCreate(User user) {
		userMapper.insert(user);
		return result;
	}
	/*
	 * 아이디를 통해 유저 정보 받아오기 (내정보 or 상대정보)
	 */
	@RequestMapping(value = "userInfo", method = RequestMethod.GET)
	public User userInfo(@Param("id") int id) {
		User user = userMapper.findOne(id);
		return user;
	}
	
	/*
	 * 현재 접속중인 유저 받아오기
	 */
	@RequestMapping("userList")
	public List<User> userList(){
		List<User> users = userMapper.findAllwithState();
		return users;
	}
	
	/*
	 * 유저 id로 삭제
	 */
	@RequestMapping(value = "userDelete", method = RequestMethod.GET)
	public String userDelete(@Param("id") int id) {
		userMapper.delete(id);
		return result;
	}
	
}
