package tws.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import tws.entity.Employee;

//作为经理，我想创建并列出所有停车男孩。这样我就可以找人为客户停车。
//AC1：我应该能够为系统创建停车男孩。停车男孩包含以下信息： employeeID：员工ID是非空字符串，表示停车男孩的唯一ID。
//AC2：我应该能够列出系统中的所有停车男孩。每个停车男孩应该包括他的employeeID。

@Mapper
public interface EmployeeMapper {
	
	@Select("select * from employee")
    List<Employee> selectAllEmployees();
    
	@Select("select * from employee OFFSET #{skipItemCount} ROWS FETCH NEXT #{pageSize} ROWS ONLY" )
    List<Employee> selectAllEmployeesPage(@Param("skipItemCount")int skipItemCount,@Param("pageSize")int pageSize);
	
	@Insert("insert into employee values(#{employee.employeeID},#{employee.name},#{employee.age})")
    void insertEmployee(@Param("employee") Employee employee); 
	
    @Update("update employee set name=#{employee.name}, age=#{employee.age} where id = #{id}")
   void updateEmployee(@Param("id") int id, @Param("employee") Employee employee);

    @Delete("delete from employee where employee.id = #{id}")
    void deleteEmployee(@Param("id") int id);
}
