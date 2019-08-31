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

import tws.entity.ParkingLot;
import tws.service.ParkingLotService;

@RestController
@RequestMapping("parkinglots")
public class ParkingLotController {

	@Autowired
	ParkingLotService parkingLotService;

	@GetMapping
	public ResponseEntity<List<ParkingLot>> queryList(@RequestParam(required = false) Map<String, Integer> pageQuery) {
		if (pageQuery.isEmpty()) {
			return ResponseEntity.ok(parkingLotService.queryParkingLots());
		}
		return pageQuery.get("page") == null || pageQuery.get("pageSize") == null ? ResponseEntity.badRequest().build()
				: ResponseEntity.ok(parkingLotService.queryParkingLotsByPage(pageQuery));
	}

	@PostMapping
	public ResponseEntity<Object> createparkingLot(@RequestBody ParkingLot parkingLot) {
		boolean createResult = parkingLotService.insert(parkingLot);
		return createResult? ResponseEntity.created(null).build() : ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateparkingLot(@PathVariable String id, @RequestBody ParkingLot parkingLot) {
		if (id == null) {
			return ResponseEntity.badRequest().build();
		}
		boolean createResult = parkingLotService.update(id, parkingLot);
		return createResult ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteparkingLot(@PathVariable String id) {
		if (id == null) {
			return ResponseEntity.badRequest().build();
		}
		boolean createResult = parkingLotService.delete(id);
		return createResult ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
	}
}
