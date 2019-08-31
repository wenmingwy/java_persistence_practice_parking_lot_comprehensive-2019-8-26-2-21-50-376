package tws.repository;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;
import tws.entity.Employee;
import tws.entity.ParkingLot;

import javax.sql.DataSource;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@MybatisTest
public class EmployeeMapperTest {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private ParkingLotMapper parkingLotMapper;
//	@Autowired
//    EmployeeMapper employeeMapperPage ;

    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @After
    public void tearDown() throws Exception {
        JdbcTestUtils.deleteFromTables(jdbcTemplate, "employee");
    }
//
//    @Test
//    public void shouldFetchAllEmployees() {
//        // given
//        jdbcTemplate.execute("INSERT INTO EMPLOYEE VALUES(1,'zhangsan', 21);");
//        // when
//        List<Employee> employeeList = employeeMapper.selectAllEmployees();
//        // then
//        assertEquals(1, employeeList.size());
//    }
////    
//    @Test
//    public void shouldFetchAllParkingLot() {
//        // given
//        jdbcTemplate.execute("");
//        // when
//        List<ParkingLot> ParkingLotList = parkingLotMapper.selectAllParkingLots();
//        // then
//        assertEquals(1, ParkingLotList.size());
//    }
    
  @Test
  public void should_Fetch_All_Employees_When_Select_Employees_By_Page_Given_PageSize_and_DisPage() {
      // given
      jdbcTemplate.execute("INSERT INTO EMPLOYEE VALUES(1,'zhangsan', 21);");
      // when
//      List<Employee> employees = employeeMapper.selectAllEmployees();
      List<Employee> employees = employeeMapper.selectAllEmployeesPage(0,1);

//      employees
      // then
//      System.out.println(employees.size());
      assertEquals(1, employees.size());
      }

}
