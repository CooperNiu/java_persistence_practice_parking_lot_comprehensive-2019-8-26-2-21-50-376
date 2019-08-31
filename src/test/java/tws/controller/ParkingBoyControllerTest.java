package tws.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.After;
import org.junit.Before;
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

import tws.entity.ParkingBoy;
import tws.entity.ParkingLot;
import tws.repository.ParkingBoyMapper;
import tws.repository.ParkingLotMapper;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
public class ParkingBoyControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper ObjectMapper;

	@Autowired
	private ParkingBoyMapper parkingBoyMapper;
	
	@Autowired
	private ParkingLotMapper parkingLotMapper;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@After
	public void tearDown() throws Exception {
		JdbcTestUtils.deleteFromTables(jdbcTemplate, "parking_boy");
	}

	@Before
	public void deleteFrromTable() throws Exception{
		jdbcTemplate.execute("delete from parking_boy");
		jdbcTemplate.execute("delete from parking_lot");
	}
	
	@Test
	public void shouldReturnParkingBoyList() throws Exception {
		jdbcTemplate.execute("INSERT INTO parking_boy VALUES('1','zhangsan')");
		List<ParkingBoy> parkingBoyList = parkingBoyMapper.select();
		String getString = ObjectMapper.writeValueAsString(parkingBoyList);

		//then
		this.mockMvc.perform(get("/parkingboys")).andDo(print())
		.andExpect(status().isOk())
				.andExpect(content().json(getString));
	}

	@Test
	public void shouldReturnParkingLotList() throws Exception {
		jdbcTemplate.execute("INSERT INTO parking_boy VALUES('1','zhangsan')");
		jdbcTemplate.execute("INSERT INTO parking_lot VALUES('1',10,10,'1')");
	    jdbcTemplate.execute("INSERT INTO parking_lot VALUES('2',10,10,'1')");
		ParkingBoy parkingBoy = parkingBoyMapper.selectById("1");
		List<ParkingLot> parkingLots = parkingLotMapper.selectByParkingBoyId("1");
		parkingBoy.setParkingLots(parkingLots);

		String getString = ObjectMapper.writeValueAsString(parkingBoy);
		this.mockMvc.perform(get("/parkingboys/" + 1 +"/parkinglots"))
		.andDo(print()).andExpect(status().isOk())
				.andExpect(content().json(getString));
	}

	@Test
	public void shouldReturnNotFound() throws Exception {
		String id =null;
		this.mockMvc.perform(get("/parkingboys/"+ id +"/parkinglots"))
		.andDo(print()).andExpect(status().isNotFound());
	}
}
