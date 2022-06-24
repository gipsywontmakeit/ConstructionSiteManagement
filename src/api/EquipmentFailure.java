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
import estgconstroi.Equipment;
import estgconstroi.Failure;

/**
 *
 * @author phrea
 */
public class EquipmentFailure implements Failure {
    
    private Equipment equipment;
    private ConstructionSite constructionSite;
    private String details;
    private String notMessage;

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
