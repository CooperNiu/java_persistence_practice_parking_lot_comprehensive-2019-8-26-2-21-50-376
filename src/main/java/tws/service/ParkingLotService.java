package tws.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tws.entity.ParkingLot;
import tws.repository.ParkingLotMapper;

@Service
public class ParkingLotService {

	@Autowired
	ParkingLotMapper parkingLotMapper;
	
	public List<ParkingLot> queryParkingLots() {
		return parkingLotMapper.select();
	}
	
	public List<ParkingLot> queryParkingLotsByPage(Map<String, Integer> pageQuery) {
		int startIndex = (pageQuery.get("page") -1) * pageQuery.get("pageSize");
		Map<String,Integer> pageMap = new HashMap<String, Integer>();
		pageMap.put("startIndex", startIndex);
		pageMap.put("pageSize", pageQuery.get("pageSize"));
		return parkingLotMapper.selectByPage(pageMap);
	}
	
	public boolean insert(ParkingLot parkingLot) {
		parkingLot.setParkingLotId(UUID.randomUUID().toString());
		return parkingLotMapper.insert(parkingLot) == 1;
	}
	
	public boolean update(String id,ParkingLot parkingLot) {
		return parkingLotMapper.update(id,parkingLot) == 1;
	}
	
	public boolean delete(String id) {
		return parkingLotMapper.deleteById(id) == 1;
	}
}
