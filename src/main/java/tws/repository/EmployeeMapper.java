package tws.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import tws.entity.ParkingBoy;

import java.util.List;

@Mapper
public interface ParkingBoyMapper {

    @Select("select * from parking_boy")
    List<ParkingBoy> selectAll();

    @Insert("insert into parking_boy values(#{parkingBoy.employeeId},#{parkingBoy.name})")
    void insert(@Param("parkingBoy") ParkingBoy employee);
}