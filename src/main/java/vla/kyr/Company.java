package vla.kyr;

/*
  @author Vlad
  @project   tdd-lab3
  @class  Company
  @version  1.0.0 
  @since 2/22/2024 - 21.01
*/

public class Company {
    private Company parent;
    private long employeeCount;

    public Company(Company parent, long employeeCount) {
        this.parent = parent;
        this.employeeCount = employeeCount;
    }

    public Company getParent() {
        return parent;
    }

    public long getEmployeeCount() {
        return employeeCount;
    }
}
