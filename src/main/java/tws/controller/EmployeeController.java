package tws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import tws.server.EmployeeServe;
import tws.service.EmployeeService;

import org.springframework.http.HttpStatus;


import java.net.URI;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService  employeeService;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployeesControll() {
    	return employeeService.selectAllEmployeesService();
    }
    
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void postEmployeesControll(@RequestBody Employee employee) {
    	employeeService.postEmployeesService(employee);
    }
    
    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable int id, @RequestBody Employee employee){
    	employeeService.updateEmployeeService(id,employee);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEmployee(@PathVariable int id) {
    	employeeService.deleteEmployeeService(id);
    }
    
//  分页功能
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> displayEmployeePage(@RequestParam(name = "pageSize")int pageSize,@RequestParam(name = "displayPag")int displayPage) {
    	List<Employee>  result = employeeService.displayEmployeePageService(pageSize,displayPage);
    	return result ;
    }
    
//    @PostMapping()
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<Employee> postEmployees(@RequestBody Employee employee) {
//        employeeMapper.insertEmployee(employee);
//        return ResponseEntity.created
//        		(URI.create("/employees/" + employee.getId())).body(employee);
//    }
    
  
 
//    @PutMapping("/{id}")
//    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee){
//        employeeMapper.updateEmployee(id,employee);
//        return ResponseEntity.ok(employee);
//    }

//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public void deleteEmployee(@PathVariable int id) {
//    	employeeMapper.deleteEmployee(id);
//    }
//    
//    @GetMapping()
//    @ResponseStatus(HttpStatus.OK)
//    public List<Employee> displayPageItem(@RequestParam(name = "pageSize")int pageSize,@RequestParam(name = "displayPag")int displayPag) {
//    	List<Employee>  result = employeeServe.getEmployeess(pageSize,displayPag);
//    	return result ;
//    }

    
}
