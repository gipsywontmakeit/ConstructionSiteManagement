/*
* Nome: José Miguel Pinto de Sousa
* Número: 8200689
* Turma: LEI
*
* Nome: Ricardo Moreira da Fonte
* Número: 8200520
* Turma: LSIRC
*
*/
package api;

import estgconstroi.ConstructionSite;
import estgconstroi.Employee;
import estgconstroi.Incident;

/**
 *
 * @author phrea
 */
public class IncidentOccurrence implements Incident {

    private Employee employee;
    private ConstructionSite constructionSite;
    private String details;
    private String notMessage;

    /**
     * constructor of the IncidenteOccurrence class
     * @param employee the employee 
     * @param constructionSite the construction site 
     * @param details any observations
     * @param notMessage notification of a message
     */
    public IncidentOccurrence(Employee employee, ConstructionSite constructionSite, String details, String notMessage) {
        this.employee = employee;
        this.constructionSite = constructionSite;
        this.details = details;
        this.notMessage = notMessage;
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

    @Override
    public String toString() {
        return "IncidentOccurrence{" + "employee=" + employee + ", constructionSite=" + constructionSite + ", details=" + details + ", notMessage=" + notMessage + '}';
    }
    
    
}
