package tws.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import tws.entity.ParkingBoy;

import java.util.List;
import java.util.Map;

@Mapper
public interface ParkingBoyMapper {
	
	List<ParkingBoy> select();
	
	ParkingBoy selectById(@Param("id") String id);
	
	List<ParkingBoy> selectByPage(@Param("map") Map<String, Integer> map);
    
	int insert(@Param("parkingBoy") ParkingBoy parkingBoy);
	
	int update(@Param("id") String id, @Param("parkingBoy") ParkingBoy parkingBoy);
	
	int deleteById(@Param("id") String id);
}
