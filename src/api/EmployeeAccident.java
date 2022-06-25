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

import estgconstroi.Accident;
import estgconstroi.ConstructionSite;
import estgconstroi.Employee;
import estgconstroi.Event;
import estgconstroi.enums.EventPriority;

/**
 *
 * @author phrea
 */
public class EmployeeAccident extends Event implements Accident {
    
    private Employee employee;
    private ConstructionSite constructionSite;
    private String details;
    private String notMessage;

    public EmployeeAccident(Employee employee, ConstructionSite constructionSite, String details, String notMessage, EventPriority priority, String title, Employee reporter) {
        super(priority, title, reporter);
        this.employee = employee;
        this.constructionSite = constructionSite;
        this.details = details;
        this.notMessage = notMessage;
    }    
    
    @Override
    public Employee getEmployee() {
        return this.employee;
    }

    @Override
    public ConstructionSite getConstructionSite() {
        return this.constructionSite;
    }

    @Override
    public String getDetails() {
        return this.details;
    }

    @Override
    public String getNotificationMessage() {
        return this.notMessage;
    }
    
}
