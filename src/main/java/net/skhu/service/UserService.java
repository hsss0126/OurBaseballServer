package net.skhu.service;

import java.util.List;

import net.skhu.dto.User;

public interface UserService {
	
	public int login(User user);
	public int update(User user);
	public int create(User user);
	public User infowithId(int id);
	public User infowithNickName(String nickName);
	public List<User> list();
	public int delete(int id);
}
