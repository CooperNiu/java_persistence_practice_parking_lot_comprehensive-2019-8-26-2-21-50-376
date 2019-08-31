package tws.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tws.entity.ParkingBoy;
import tws.service.ParkingBoyService;

@RestController
@RequestMapping("parkingboys")
public class ParkingBoyController {

	@Autowired
	ParkingBoyService parkingBoyService;
	@GetMapping
	public ResponseEntity<List<ParkingBoy>> queryList(@RequestParam(required = false) Map<String, Integer> pageQuery){
		if (pageQuery.isEmpty()) {
			return ResponseEntity.ok(parkingBoyService.queryParkingBoys());
		}
		return pageQuery.get("page") == null || pageQuery.get("pageSize") == null ? ResponseEntity.badRequest().build() : ResponseEntity.ok(parkingBoyService.queryParkingBoysByPage(pageQuery));
	}
	
	@GetMapping("/{id}/parkinglots")
	public ResponseEntity<ParkingBoy> queryParkingLotList(@PathVariable String id){
		ParkingBoy parkingBoy = parkingBoyService.queryParkingLots(id);
		if (parkingBoy == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(parkingBoy);
	}
	
	@PostMapping
	public ResponseEntity<Object> createParkingBoy(@RequestBody ParkingBoy parkingBoy) {
		boolean createResult = parkingBoyService.insert(parkingBoy);
		return createResult  ? ResponseEntity.created(null).build():ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateParkingBoy(@PathVariable String id,@RequestBody ParkingBoy parkingBoy) {
		if (id == null) {
			return ResponseEntity.badRequest().build();
		}
		boolean createResult = parkingBoyService.update(id,parkingBoy);
		return createResult ? ResponseEntity.ok().build():ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteParkingBoy(@PathVariable String id) {
		if (id == null) {
			return ResponseEntity.badRequest().build();
		}
		int createResult = parkingBoyService.delete(id);
		return createResult == 1? ResponseEntity.ok().build():ResponseEntity.notFound().build();
	}
}
