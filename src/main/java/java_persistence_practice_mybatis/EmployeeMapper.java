package java_persistence_practice_mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import tws.entity.Employee;
//Story 1
//作为经理，我想创建并列出所有停车男孩。这样我就可以找人为客户停车。
//AC1：我应该能够为系统创建停车男孩。停车男孩包含以下信息： employeeID：员工ID是非空字符串，表示停车男孩的唯一ID。
//AC2：我应该能够列出系统中的所有停车男孩。每个停车男孩应该包括他的employeeID。
@Mapper
public interface EmployeeMapper {
//	全部查询
	@Select("select * from employee")
    List<Employee> selectAllEmployees();
//    进行插入操作
	@Insert("insert into employee values(#{employeeID},#{name},#{age})")
    void insertEmployee(@Param("employee") Employee employee); 
}