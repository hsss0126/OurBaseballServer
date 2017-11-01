package net.skhu.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	/*
	 * 로그인 할때, 중복확인 할때 닉네임을 통해 유저 정보 받아오기
	 * 중복확인 시에는 반환되는 정보가 있으면 중복
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public int login(@RequestBody User user) {
		System.out.println(user.toString());
		User user1 = userMapper.findOnewithNickName(user.getNickName());
		//해당 닉네임을 가진 데이터가 존재한다면
		if(user1 != null) {
			System.out.println(user1.toString());
			if(user1.getPassword().equals(user.getPassword())) {
				return ResponseCode.login_success;
			} else {
				return ResponseCode.pwd_error;
			}
		} else {
			return ResponseCode.id_error;
		}
		
		
	}
	
	/*
	 * user정보 업데이트
	 * 접속 상태 나 승패관련 정보
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(User user) {
		userMapper.update(user);
		return null;
	}
	
	/*
	 * 가입 시 유저 목록에 추가
	 */
	@RequestMapping(value = "create", method = RequestMethod.POST, headers = "Accept=application/json; charset=UTF-8")
	public int create(@RequestBody User user) {
		userMapper.insert(user);
		return ResponseCode.join_success;
	}
	/*
	 * 아이디를 통해 유저 정보 받아오기 (내정보 or 상대정보)
	 */
	@RequestMapping(value = "infowithId", method = RequestMethod.GET)
	public User infowithId(@Param("id") int id) {
		User user = userMapper.findOne(id);
		return user;
	}
	@RequestMapping(value = "infowithNickName", method = RequestMethod.GET)
	public User infowithNickName(@Param("nickName") String nickName) {
		User user = userMapper.findOnewithNickName(nickName);
		return user;
	}
	
	/*
	 * 현재 접속중인 유저 받아오기
	 */
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public List<User> list(){
		List<User> users = userMapper.findAllwithState();
		return users;
	}
	
	/*
	 * 유저 id로 삭제
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(@Param("id") int id) {
		userMapper.delete(id);
		return null;
	}
	
}
