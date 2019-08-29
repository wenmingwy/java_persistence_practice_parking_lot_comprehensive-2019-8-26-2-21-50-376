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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import tws.entity.Employee;
import tws.repository.EmployeeMapper;
import org.springframework.http.HttpStatus;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeMapper employeeMapper;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployees() {
    	return employeeMapper.selectAllEmployees();
    }
    
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Employee> postEmployees(@RequestBody Employee employee) {
        employeeMapper.insertEmployee(employee);
        return ResponseEntity.created
        		(URI.create("/employees/" + employee.getId())).body(employee);
    }
 
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee){
        employeeMapper.updateEmployee(id,employee);
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEmployee(@PathVariable int id) {
    	employeeMapper.deleteEmployee(id);
    }
    
}
