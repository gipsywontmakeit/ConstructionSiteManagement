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
import estgconstroi.InsuranceReporter;
import estgconstroi.enums.EmployeeType;
import estgconstroi.enums.EventPriority;
import estgconstroi.exceptions.EventManagerException;
import java.io.IOException;
import java.lang.invoke.WrongMethodTypeException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import json.JSONOperation;

/**
 *
 * @author phrea
 */
public class API {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        UUID uuid = UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d");

        Worker e1 = new Worker("Veracio", EmployeeType.MANAGER, uuid.randomUUID().toString());
        JSONOperation export = new JSONOperation();
        EmployeeAccident a1 = new EmployeeAccident(e1, null, "aaa", "bbb", EventPriority.NORMAL, "asasa", e1);
        
        WorkerEventManager wem1 = new WorkerEventManager();

        for (int i = 0; i <= 110; i++) {
            try {
                wem1.reportEvent(a1);
            } catch (EventManagerException ex) {
                ex.printStackTrace();
            }
        }
        
        export.exportEvent(wem1.getEvent(EmployeeAccident.class));
        // InsuranceReporter ir = new InsuranceReporter();
        // System.out.println(uuid.randomUUID());
        // System.out.println(e1);
    }

}
