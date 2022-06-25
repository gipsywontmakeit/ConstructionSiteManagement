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

import estgconstroi.ConstructionSite;
import estgconstroi.Employee;
import estgconstroi.Event;
import estgconstroi.enums.EventPriority;
import java.util.Objects;

/**
 *
 * @author phrea
 */
public class WorkEvent extends Event {

    public WorkEvent(ConstructionSite constructionSite, String details, String notifyMessage, EventPriority priority, String title, Employee reporter) {
        super(priority, title, reporter);
        this.constructionSite = constructionSite;
        this.details = details;
        this.notifyMessage = notifyMessage;
    }

    private ConstructionSite constructionSite;
    private String details;
    private String notifyMessage;

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
        return this.notifyMessage;
    }

    @Override
    public String toString() {
        return "WorkEvent{" + "constructionSite=" + constructionSite + ", details=" + details + ", notifyMessage=" + notifyMessage + '}';
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
        final WorkEvent other = (WorkEvent) obj;
        return this.constructionSite == other.constructionSite;
    }

    
}
