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
import api.Worker;
import api.WorkersTeam;
import json.JSONOperation;
import estgconstroi.Event;
import estgconstroi.InsuranceReporter;
import estgconstroi.enums.EmployeeType;
import estgconstroi.enums.EquipmentStatus;
import estgconstroi.enums.EquipmentType;
import estgconstroi.enums.EventPriority;
import estgconstroi.exceptions.ConstructionSiteException;
import estgconstroi.exceptions.EventManagerException;
import estgconstroi.exceptions.TeamException;
import java.awt.BorderLayout;
import java.io.IOException;
import java.lang.invoke.WrongMethodTypeException;
import java.time.LocalDate;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import json.JSONOperation;
import java.util.Scanner;


/**
 *
 * @author phrea
 */
public class API {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        Scanner op = new Scanner(System.in);

        UUID uuid = UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d");

        Worker e1 = new Worker("Veracio", EmployeeType.MANAGER, uuid.randomUUID().toString());
        Worker e2 = new Worker("Almeida", EmployeeType.TEAM_LEADER, uuid.randomUUID().toString());
        Worker e3 = new Worker("Vasco", EmployeeType.WORKER, uuid.randomUUID().toString());

        WorkersTeam wt1 = new WorkersTeam("team 1", 3);
        WorkersTeam wt2 = new WorkersTeam("team 2", 4);

        RegConstructionSite cs1 = new RegConstructionSite("Shipyard", "Porto", "30 days", LocalDate.EPOCH, e1);

        WorkerEventManager wem1 = new WorkerEventManager();
        WorkerEventManager wem2 = new WorkerEventManager();

        ConstructionSiteEquipment cse1 = new ConstructionSiteEquipment("Hammer", EquipmentType.TOOLS, EquipmentStatus.OPERATIVE);
        ConstructionSiteEquipment cse2 = new ConstructionSiteEquipment("Truck", EquipmentType.HEAVY_DUTY, EquipmentStatus.OPERATIVE);
        ConstructionSiteEquipment cse3 = new ConstructionSiteEquipment("Multi-functions", EquipmentType.HEAVY_DUTY, EquipmentStatus.INOPERATIVE);

        NotifierCollection nc1 = new NotifierCollection("Worker" + e3.getName() + "has injured with the " + cse1.getName(), EventPriority.IMMEDIATE, null);

        EmployeeAccident ea1 = new EmployeeAccident(e1, cs1, "hello", "Hammer on the finger", EventPriority.IMMEDIATE, "Hammer injury", e1);
        EquipmentFailure ef1 = new EquipmentFailure(cse3, cs1, "Multi-functions not working due oil engine", "Multi-functions", EventPriority.HIGH, "Multi-Functions not working", e2);

        IncidentOccurrence io1 = new IncidentOccurrence(e3, cs1, "Schedule a meeting", "Scheduling");

        Event[] events = wem1.getEvent(EmployeeAccident.class);

        InsuranceReporter ir = new InsuranceReporter();
 

        JSONOperation export = new JSONOperation();

        System.out.println("1 - add employee\n2 - remove employee\n3 - add team\n4 - remove team\n5 - add equipment\n6 - remove equipment\n7 - add event\n8 - remove event\n9 - export json\n10 - send event to insurance\n 11 - remove an event from insurance\n12 - reset events");

        switch (op.nextInt()) {
            case 1: 
                try {
                wt1.addEmployees(e1);
                System.out.println("employee added");
            } catch (TeamException ex) {
                ex.printStackTrace();
            }

            break;
            case 2: 
                try {
                wt1.removeEmployees(e3);
                System.out.println("employee removed");
            } catch (TeamException ex) {
                ex.printStackTrace();
            }

            break;
            case 3: 
                try {
                cs1.addTeam(wt1);
                System.out.println("team added");
            } catch (ConstructionSiteException ex) {
                ex.printStackTrace();
            }

            break;
            case 4: 
                try {
                cs1.removeTeam(wt2);
            } catch (ConstructionSiteException ex) {
                ex.printStackTrace();
            }

            System.out.println("team removed");
            case 5: 
                try {
                cs1.addEquipment(cse1);
            } catch (ConstructionSiteException ex) {
                ex.printStackTrace();
            }

            System.out.println("equipment added");
            case 6: 
                try {
                cs1.removeEquipment(cse3);
            } catch (ConstructionSiteException ex) {
                ex.printStackTrace();
            }

            System.out.println("equipment removed");
            case 7: 
                try {
                wem1.reportEvent(ea1);
            } catch (EventManagerException ex) {
                ex.printStackTrace();
            }
            System.out.println("team removed");
            break;

            case 8: 
                try {
                wem2.removeEvent(ef1);
            } catch (EventManagerException ex) {
                ex.printStackTrace();
            }
            System.out.println("team removed");
            break;
            case 9:
                try {
                export.exportEvent(events, "\\src\\api", "Accident.json");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            System.out.println("file created");
            break;
            case 10:
                try {
                    InsuranceReporter.addEvent(export.convertToJsonString(events));
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.out.println("event sent to the insurance");
                break;
            default:
                System.out.println("Wrong option");
                break;
        }

    }

 
}
