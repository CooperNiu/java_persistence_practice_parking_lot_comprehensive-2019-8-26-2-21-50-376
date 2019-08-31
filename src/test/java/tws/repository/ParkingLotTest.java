package tws.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;

import tws.entity.ParkingLot;
@RunWith(SpringRunner.class)
@MybatisTest
public class ParkingLotTest {

    @Autowired
    private ParkingLotMapper parkingLotMapper;

    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @After
    public void tearDown() throws Exception {
        JdbcTestUtils.deleteFromTables(jdbcTemplate, "employee");
    }

    @Test
    public void shouldFetchAllParkingLot() {
        // given
        jdbcTemplate.execute("");
        // when
        List<ParkingLot> ParkingLotList = parkingLotMapper.selectAll();
        // then
        assertEquals(1, ParkingLotList.size());
    }
    @Test
    public void should_return_one_parkingLot(int id) {
        // given
        jdbcTemplate.execute("");
        // when
        List<ParkingLot> ParkingLotList = parkingLotMapper.selectById(id);
        // then
        assertEquals(1, ParkingLotList.size());
    }

}
