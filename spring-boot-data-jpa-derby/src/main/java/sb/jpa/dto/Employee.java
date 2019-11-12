package sb.jpa.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
    public Employee(){}
    public Employee(String empName,int empSalary){
        this.empName = empName;
        this.empSalary = empSalary;
    }

    @Id
    private int empId;
    private String empName;
    private int empSalary;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(int empSalary) {
        this.empSalary = empSalary;
    }


}
