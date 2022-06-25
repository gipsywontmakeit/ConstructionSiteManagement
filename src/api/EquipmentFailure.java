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
import estgconstroi.Equipment;
import estgconstroi.Event;
import estgconstroi.Failure;
import estgconstroi.enums.EventPriority;

/**
 *
 * @author phrea
 */
public class EquipmentFailure extends Event implements Failure {
    
    private Equipment equipment;
    private ConstructionSite constructionSite;
    private String details;
    private String notMessage;

    public EquipmentFailure(Equipment equipment, ConstructionSite constructionSite, String details, String notMessage, EventPriority priority, String title, Employee reporter) {
        super(priority, title, reporter);
        this.equipment = equipment;
        this.constructionSite = constructionSite;
        this.details = details;
        this.notMessage = notMessage;
    }

    @Override
    public Equipment getEquipment() {
        return this.equipment;
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
