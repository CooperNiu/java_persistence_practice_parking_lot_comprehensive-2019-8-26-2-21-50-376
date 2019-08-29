package tws.mapper;

import org.apache.ibatis.annotations.Mapper;
import tws.entity.Employee;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    public List<Employee> getAll();
}
