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
import estgconstroi.Notifier;
import estgconstroi.enums.EventPriority;
import java.util.Arrays;

/**
 *
 * @author phrea
 */
public class NotifierCollection implements Notifier {
    
    private static final int MAX_EMPLOYEES = 100;
    
    private String message;
    private EventPriority eventPriority;
    private Employee[] employee = new Employee[MAX_EMPLOYEES];
    private int cont;

    public NotifierCollection(String message, EventPriority eventPriority, Employee[] employee) {
        this.message = message;
        this.eventPriority = eventPriority;
        this.employee = new Employee[MAX_EMPLOYEES];
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public EventPriority getEventPriority() {
        return eventPriority;
    }

    public void setEventPriority(EventPriority eventPriority) {
        this.eventPriority = eventPriority;
    }

    public Employee[] getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee[this.cont] = employee;
        cont++;
    }

    @Override
    public void notify(String string, EventPriority ep, Employee empl) {
        System.out.println(toString());
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NotifierCollection other = (NotifierCollection) obj;
        return this.employee == other.employee;
    }

    

    @Override
    public String toString() {
        return "NotifierCollection{" + "message=" + message + ", eventPriority=" + eventPriority + ", employee=" + employee + '}';
    }
    
}
