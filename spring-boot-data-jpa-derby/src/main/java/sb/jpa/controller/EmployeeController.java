package sb.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;
import sb.jpa.dto.Employee;
import sb.jpa.repository.EmployeeRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

@RestController
@RequestMapping(value = "/employee/")
public class EmployeeController {

    private Logger logger = (Logger) Logger.getLogger("EmployeeController");
    private AtomicInteger atId = new AtomicInteger(100);
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping(value = "/count")
    public String getEmpCount(){
        return "Count is "+employeeRepository.count();
    }

    @PostMapping(value = "/add")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setEmpId(atId.incrementAndGet());
        employeeRepository.save(employee);
        logger.log(INFO,"New Employee details added");
        return employee;
    }

    @GetMapping(value = "/view")
    public List<Employee> getAllEmployees(){
        logger.log(INFO,"Viewing all employee details");
        return (List<Employee>) employeeRepository.findAll();
    }

    @GetMapping(value = "/view/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        logger.log(INFO,"Fetching details of employee with id:"+id);
        return employeeRepository.findById(id).get();
    }

    @DeleteMapping(value = "/delete")
    public String deleteEmployee(){
        logger.log(INFO,"Deleting details of all employees");
        employeeRepository.deleteAll();
        return "All details cleared";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteEmployeeById(@PathVariable int id){
        logger.log(INFO,"Deleting details of employee with id:"+id);
        employeeRepository.deleteById(id);
        return "Details of emp with id:"+id;
    }

    @PutMapping(value = "/update/{id}")
    public String updateEmployeeById(@RequestBody Employee employee,
                                     @PathVariable int id){
        if(null!=employeeRepository.findById(id)){
            employeeRepository.save(employee);
        }
        return "";
    }

    @ExceptionHandler(value = {NoSuchElementException.class,
            EmptyResultDataAccessException.class})
    public String throwException(){
        logger.log(INFO,"404:No record found to perform an action");
        return "404:No record found to perform an action";
    }
}
