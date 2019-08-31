package tws.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;

import tws.entity.ParkingLot;

@RunWith(SpringRunner.class)
@MybatisTest
class ParkingLotMapperTest {

	 @Autowired
	 private ParkingLotMapper parkingLotMapper;
	 
	 JdbcTemplate jdbcTemplate;

	    @Autowired
	    public void setDataSource(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource);
	    }

	    @After
	    public void tearDown() throws Exception {
	        JdbcTestUtils.deleteFromTables(jdbcTemplate, "parking_lot");
	    }

	    @BeforeEach
	    public void deleteFromTable() {
	    	jdbcTemplate.execute("delete from parking_lot");
	    }

	    @Test
	    public void shouldFetchAllParkingLots() {
	        // given
	        jdbcTemplate.execute("INSERT INTO parking_lot VALUES('1',10,10,'1');");
	        // when
	        List<ParkingLot> parkingLotList = parkingLotMapper.select();
	        // then
	        assertEquals(1, parkingLotList.size());
	    }
	    
	    @Test
	    public void should_return_1_when_insert_parking_boy() {
	        // given
	    	ParkingLot parkingLot = new ParkingLot("1",10,10);
	        // when
	        int result = parkingLotMapper.insert(parkingLot);
	        // then
	        assertEquals(1, result);
	    }
	    
	    @Test
	    public void should_return_1_when_update_parking_boy() {
	        // given
	    	jdbcTemplate.execute("INSERT INTO parking_lot VALUES('1',10,10,'1');");
	    	ParkingLot parkingLot = new ParkingLot("1",10,10);
	        
	        // when
	        int result = parkingLotMapper.update("1",parkingLot);
	        // then
	        assertEquals(1, result);
	    }
	    
	    @Test
	    public void should_return_1_when_delete_parking_boy() {
	        // given
	    	jdbcTemplate.execute("INSERT INTO parking_lot VALUES('1',10,10,'1');");        
	        // when
	        int result = parkingLotMapper.deleteById("1");
	        // then
	        assertEquals(1, result);
	    }
}
