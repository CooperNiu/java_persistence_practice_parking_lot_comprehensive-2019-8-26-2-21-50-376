package tws.repository;

import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;
import tws.entity.ParkingBoy;

import javax.sql.DataSource;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@MybatisTest
public class ParkingBoyMapperTest {

    @Autowired
    private ParkingBoyMapper parkingBoyMapper;

    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @After
    public void tearDown() throws Exception {
        JdbcTestUtils.deleteFromTables(jdbcTemplate, "parking_boy");
    }

    @BeforeEach
    public void deleteFromTable() {
    	jdbcTemplate.execute("delete from parking_boy");
    }
    
    @Test
    public void shouldFetchAllParkingBoys() {
        // given
        jdbcTemplate.execute("INSERT INTO parking_boy VALUES(1,'zhangsan');");
        // when
        List<ParkingBoy> parkingBoyList = parkingBoyMapper.select();
        // then
        assertEquals(1, parkingBoyList.size());
    }
    
    @Test
    public void should_return_1_when_insert_parking_boy() {
        // given
    	ParkingBoy parkingBoy = new ParkingBoy("1","zhangsan");
        // when
        int result = parkingBoyMapper.insert(parkingBoy);
        // then
        assertEquals(1, result);
    }
    
    @Test
    public void should_return_1_when_update_parking_boy() {
        // given
    	jdbcTemplate.execute("INSERT INTO parking_boy VALUES(1,'zhangsan');");
    	ParkingBoy parkingBoy = new ParkingBoy("1","sdhxy");
        
        // when
        int result = parkingBoyMapper.update("1",parkingBoy);
        // then
        assertEquals(1, result);
    }
    
    @Test
    public void should_return_1_when_delete_parking_boy() {
        // given
    	jdbcTemplate.execute("INSERT INTO parking_boy VALUES(1,'zhangsan');");        
        // when
        int result = parkingBoyMapper.deleteById("1");
        // then
        assertEquals(1, result);
    }
}
