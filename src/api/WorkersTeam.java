/*
* Nome: José Miguel Pinto de Sousa
* Número: 8200689
* Turma: LEI
*
* Nome: Ricardo Moreira da Fonte
* Número: 8200520
* Turma: LSIRC
 */
package api;

import estgconstroi.Employee;
import estgconstroi.Team;
import estgconstroi.enums.EmployeeType;
import estgconstroi.exceptions.TeamException;

/**
 *
 * @author phrea
 */
public class WorkersTeam implements Team {

    private final int MAX_EMPLOYEES = 100;

    private String name;
    private int employeesNumber;
    private Employee[] employees = new Employee[MAX_EMPLOYEES];

    public WorkersTeam(String name, Worker[] employees) {
        this.name = name;
        this.employees = new Employee[MAX_EMPLOYEES];
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getNumberOfEmployees() {
        return this.employeesNumber;
    }

    @Override

    public void addEmployees(Employee empl) throws TeamException {

        if (this.employeesNumber == this.MAX_EMPLOYEES) {
            increaseArraySize();
        }
        
        if (empl.getUUID() == null) {
            throw new TeamException("Employee already in the team");
        }
    
        this.employees[this.employeesNumber++] = empl;
    }

    @Override
    public void removeEmployees(Employee empl) throws TeamException {

        if (empl instanceof Employee) {

        } else {
            throw new TeamException("Employee is not in the team");
        }

    }

    @Override
    public Employee[] getEmployees(String string) {
        Employee[] name = new Employee[employees.length];
        int j = 0;
        for (int i = 0; i < employees.length; i++) {
            if(employees[i].getName().equals(string)) {
                name[j++] = employees[i];
            }
        }
        return name;
    }

    @Override
    public Employee[] getEmployees(EmployeeType et) {
        Employee[] type = new Employee[employees.length];
        int j = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getType().equals(et)) {
                type[j++] = employees[i];
            }
        }
        return type;
    }

    @Override
    public Employee[] getEmployees() {
        return this.employees;
    }
    
    /**
     * method to increase the size of the Employee's array
     */
    public void increaseArraySize() {
        Employee[] temp = new Employee[employees.length * 2];
        
        for (int i = 0; i < employees.length; i++) {
            temp[i] = employees[i];
        }
        employees = temp;
    }


    public WorkersTeam(String name, int employeesNumber) {
        this.name = name;
        this.employeesNumber = employeesNumber;
    }
    
    
}
