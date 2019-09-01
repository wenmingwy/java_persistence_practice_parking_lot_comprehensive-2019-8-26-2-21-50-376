package tws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import tws.entity.Employee;
import tws.repository.EmployeeMapper;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper  employeeMapper;
    
//    
//    @GetMapping("/")
//    @ResponseStatus(HttpStatus.OK)
    public List<Employee> selectAllEmployeesService() {
    	return employeeMapper.selectAllEmployees();
    }
    
//    @PostMapping()
//    @ResponseStatus(HttpStatus.CREATED)
    public void postEmployeesService(Employee employee) {
        employeeMapper.insertEmployee(employee);
    }
    
//    @PutMapping("/{id}")
    public void updateEmployeeService(int id,  Employee employee){
        employeeMapper.updateEmployee(id,employee);
    }
    
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
    public void deleteEmployeeService( int id) {
    	employeeMapper.deleteEmployee(id);
    }
    
////  分页功能
//  @GetMapping()
//  @ResponseStatus(HttpStatus.OK)
  public List<Employee> displayEmployeePageService(int pageSize,int displayPage) {
  	List<Employee> result = employeeMapper.selectAllEmployeesPage(pageSize,displayPage);
  	return result ;
  }
}
