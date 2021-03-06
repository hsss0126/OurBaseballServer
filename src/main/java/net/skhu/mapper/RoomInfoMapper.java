package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import net.skhu.dto.RoomInfo;

@Mapper
public interface RoomInfoMapper {

	RoomInfo findOne(int id);
	RoomInfo findOnewithHostId(int hostId);
	List<RoomInfo> findAll(@Param("orderBy") String orderBy);
	void insert(RoomInfo roomInfo);
	void update(RoomInfo roomInfo);
	void delete(int id);
}
