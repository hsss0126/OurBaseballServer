package net.skhu.service;

import java.util.List;

import net.skhu.dto.User;

public interface UserService {
	
	public int login(User user);
	public int update(User user);
	public int create(User user);
	public User findById(int id);
	public User infoByNickName(String nickName);
	public List<User> list();
	public int delete(int id);
}
