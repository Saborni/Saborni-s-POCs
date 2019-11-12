package sb.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import sb.jpa.dto.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
    //custom queries
}
