package tws.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import tws.entity.ParkingLot;

@Mapper
public interface ParkingLotMapper {

    List<ParkingLot> select();
    
    List<ParkingLot> selectByParkingBoyId(@Param("parkingBoyId") String parkingBoyId);
    
    List<ParkingLot> selectByPage(@Param("map") Map<String, Integer> map);
    
	int insert(@Param("parkingLot") ParkingLot parkingLot);
	
	int update(@Param("id") String id, @Param("parkingLot") ParkingLot parkingLot);
	
	int deleteById(@Param("id") String id);
}
