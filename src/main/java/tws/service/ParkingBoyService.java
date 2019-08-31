package tws.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tws.contant.Contant;
import tws.entity.ParkingBoy;
import tws.entity.ParkingLot;
import tws.repository.ParkingBoyMapper;
import tws.repository.ParkingLotMapper;

@Service
public class ParkingBoyService {

	@Autowired
	ParkingBoyMapper parkingBoyMapper;
	@Autowired
	ParkingLotMapper parkingLotMapper;
	
	public List<ParkingBoy> queryParkingBoys() {
		return parkingBoyMapper.select();
	}
	
	public List<ParkingBoy> queryParkingBoysByPage(Map<String, Integer> pageQuery) {
		int startIndex = (pageQuery.get("page") -1) * pageQuery.get("pageSize");
		Map<String,Integer> pageMap = new HashMap<String, Integer>();
		pageMap.put("startIndex", startIndex);
		pageMap.put("pageSize", pageQuery.get("pageSize"));
		return parkingBoyMapper.selectByPage(pageMap);
	}
	
	public ParkingBoy queryParkingLots(String id) {
		ParkingBoy parkingBoy = new ParkingBoy();		
		parkingBoy = parkingBoyMapper.selectById(id);
		List<ParkingLot> parkingLots = parkingLotMapper.selectByParkingBoyId(id);
		if (parkingLots.size() != 0) {
			parkingBoy.setParkingLots(parkingLots);
		}
		return parkingBoy;
	}
	
	public boolean insert(ParkingBoy parkingBoy) {
		parkingBoy.setEmployeeId(UUID.randomUUID().toString());
		return parkingBoyMapper.insert(parkingBoy) == 1 ;
	}
	
	public boolean update(String id,ParkingBoy parkingBoy) {
		return parkingBoyMapper.update(id,parkingBoy) == 1 ;
	}
	
	public int delete(String id) {
		return parkingBoyMapper.deleteById(id) == 1 ? Contant.ONE:Contant.TWO;
	}
}
