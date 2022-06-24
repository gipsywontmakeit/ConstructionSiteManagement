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

import estgconstroi.Equipment;
import estgconstroi.enums.EquipmentStatus;
import estgconstroi.enums.EquipmentType;
/**
 *
 * @author Ricardo
 */
public class ConstructionSiteEquipment implements Equipment{
    
    /**
     * name of the construction site
     */
    private String name;
    
    /**
     * type of the equipment 
     */
    private EquipmentType type;
    
    
    private EquipmentStatus status;

    public ConstructionSiteEquipment(String name, EquipmentType type, EquipmentStatus status) {
        this.name = name;
        this.type = type;
        this.status = status;
    }
     

    
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public EquipmentType getType() {
        return type;
    }

    @Override
    public EquipmentStatus getStatus() {
        return status;
    }

    @Override
    public void setStatus(EquipmentStatus es) {
        this.status = es;
    }

    @Override
    public String toString() {
        return "ConstructionSiteEquipment{" + "name=" + name + ", type=" + type + ", status=" + status + '}';
    }
    
    
    
    
    
}
