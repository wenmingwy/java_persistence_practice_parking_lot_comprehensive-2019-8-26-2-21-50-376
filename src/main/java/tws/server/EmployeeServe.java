package tws.server;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import tws.entity.Employee;
import tws.repository.EmployeeMapper;
@Service
public class EmployeeServe {
	@Autowired
    EmployeeMapper employeeMapper ;
	
//	@GetMapping()
//    @ResponseStatus(HttpStatus.OK)
//    public List<Employee> getEmployees() {
//    	List<Employee> employees =  employeeMapper.selectAllEmployees();
//    	for(int i = 0; i<employees.size();i++) {
////    		employees.get(i).set(i, employees.get(i));
//    		employees.get(i).setName("中原银行"+employees.get(i).getName());
//    	}
//    	return employees;
//    }
	
	@GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployeess(int pageSize,int displayPag) {
//    	int pageSize = 5 ;
//    	int employeesCount = employees.size();
//    	int displayPag = 2 ;
    	int skipItemCount = pageSize * (displayPag - 1) ;
//    	List<Employee> resultEmployees = null;
//    	for(int i = skipItemCount;i<skipItemCount+pageSize && i<employeesCount;i++) {
//    		resultEmployees.add(employees.get(i));
//    	}
    	List<Employee> employees =  employeeMapper.selectAllEmployeesPage(skipItemCount,pageSize);
    	return employees;
    }
 
	
	
}
