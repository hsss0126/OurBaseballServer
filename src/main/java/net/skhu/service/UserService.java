package net.skhu.service;

import java.util.List;

import net.skhu.dto.User;

public interface UserService {
	
	public int login(User user);
	public int update(User user);
	public int create(User user);
	public User infobyId(int id);
	public User infobyNickName(String nickName);
	public List<User> list();
	public int delete(int id);
}
