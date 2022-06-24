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
import estgconstroi.enums.EmployeeType;
import java.util.UUID;

/**
 * This class represents an Employee from the company and his information
 * @author phrea
 */
public class Worker extends Employee {
    
   
    
    private String uuid = UUID.randomUUID().toString();
    /**
     * name of the worker
     */
    private final String name;
    
    /**
     * role of the worker
     */
    private EmployeeType type;
    
    
    /**
     * constructor from the Worker class
     * @param name name of the worker
     * @param type role of the worker
     */
    public Worker(String name, EmployeeType type, String uuid) {
        this.name = name;
        this.type = type;
        this.uuid = uuid;
    }
    
    
    /**
     * getter for name
     * @return 
     */
    @Override
    public String getName() {
        return this.name;
    }
    
    /**
     * getter for type
     * @return 
     */
    @Override
    public EmployeeType getType() {
        return this.type;
    }
    
    /**
     * setter for type
     * @param et employee's role
     */
    @Override
    public void setType(EmployeeType et) {
        this.type = et;
    }

    @Override
    public String getUUID() {
        return this.uuid;
    }

    @Override
    public String toString() {
        return "Worker{" + "uuid=" + uuid + ", name=" + name + ", type=" + type + '}';
    }

    

    

    
    
    
}
