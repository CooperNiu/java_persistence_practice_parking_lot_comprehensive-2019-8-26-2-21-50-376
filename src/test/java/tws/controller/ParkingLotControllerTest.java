package tws.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import tws.entity.ParkingLot;
import tws.repository.ParkingLotMapper;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
public class ParkingLotControllerTest {

	@Autowired
	ParkingLotMapper parkingLotMapper;
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper ObjectMapper;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@After
	public void tearDown() throws Exception {
		JdbcTestUtils.deleteFromTables(jdbcTemplate, "parking_lot");
	}
	

	@Test
	public void shouldReturnParkingBoyList() throws Exception {
		jdbcTemplate.execute("INSERT INTO parking_lot VALUES('1',10,10,1)");
		List<ParkingLot> parkingLoyList = parkingLotMapper.select();

		String getString = ObjectMapper.writeValueAsString(parkingLoyList);
		this.mockMvc.perform(get("/parkinglots")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().json(getString));
	}
	
}
