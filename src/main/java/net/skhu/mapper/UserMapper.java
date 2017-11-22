 package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.skhu.dto.User;

@Mapper
public interface UserMapper {

	User findOne(int id);
	User findOneByNickName(String nickName);
	List<User> findAll();
	List<User> findAllByState();
	void insert(User user);
	void update(User user);
	void delete(int id);
	
	
}
