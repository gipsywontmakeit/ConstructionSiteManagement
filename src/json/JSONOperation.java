/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package json;

import api.EmployeeAccident;
import api.EquipmentFailure;
import estgconstroi.Event;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Nome: José Miguel Pinto de Sousa Número: 8200689 Turma: LEI
 * <p>
 * Nome: Ricardo Moreira da Fonte Número: 8200520 Turma: LSIRC
 */
public class JSONOperation {

    public void readAccidentEvent() throws FileNotFoundException, IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("src\\jsonText\\AccidentEvent.json");

        Object obj = jsonParser.parse(reader);

        JSONObject empJSONObject = (JSONObject) obj;
        JSONObject event = (JSONObject) empJSONObject.get("event");

        String gn = (String) empJSONObject.get("groupname");
        String gk = (String) empJSONObject.get("groupkey");

        System.out.println(gn);
        System.out.println(gk);

        System.out.println(empJSONObject.get("event"));

    }

    public void readFailureEvent() throws FileNotFoundException, IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("src\\jsonText\\FailureEvent.json");

        Object obj = jsonParser.parse(reader);

        JSONObject empJSONObject = (JSONObject) obj;
        JSONObject event = (JSONObject) empJSONObject.get("event");

        String gn = (String) empJSONObject.get("groupname");
        String gk = (String) empJSONObject.get("groupkey");

        System.out.println(gn);
        System.out.println(gk);

        System.out.println(empJSONObject.get("event"));

    }

    public void readIncidentEvent() throws FileNotFoundException, IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("src\\jsonText\\IncidentEvent.json");

        Object obj = jsonParser.parse(reader);

        JSONObject empJSONObject = (JSONObject) obj;
        JSONObject event = (JSONObject) empJSONObject.get("event");

        String gn = (String) empJSONObject.get("groupname");
        String gk = (String) empJSONObject.get("groupkey");

        System.out.println(gn);
        System.out.println(gk);

        System.out.println(empJSONObject.get("event"));

    }

    public boolean createFile(String path) {
        try {
            File myObj = new File(path);
            if (myObj.createNewFile()) {
                return true;
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return false;
    }

    public void exportEvent(Event[] event, String path, String path2) throws IOException {
        JSONObject accident = new JSONObject();
        JSONObject accidentEvent = new JSONObject();
        JSONArray events = new JSONArray();

        for (int i = 0; i < event.length; i++) {
            if (event[i] != null && event[i] instanceof EmployeeAccident) {
                accident.put("groupname", "Grupo21");
                accident.put("groupkey", "xptoififirieidifie");
                accidentEvent.put("priority", event[i].getPriority().toString());
                accidentEvent.put("title", event[i].getTitle());
                accidentEvent.put("data", event[i].getDate().toString());
                accidentEvent.put("uuid", event[i].getUuid());
                accidentEvent.put("eventtype", "Accident");
                accident.put("event", accidentEvent);
                events.add(accident);

            } else if (event[i] != null && event[i] instanceof EquipmentFailure) {
                accident.put("groupname", "Grupo21");
                accident.put("groupkey", "xptoififirieidifie");
                accidentEvent.put("priority", event[i].getPriority().toString());
                accidentEvent.put("title", event[i].getTitle());
                accidentEvent.put("data", event[i].getDate().toString());
                accidentEvent.put("uuid", event[i].getUuid());
                accident.put("event", accidentEvent);
                accidentEvent.put("eventtype", "Failure");
                events.add(accident);
            }
        }

        createFile(path);
        
        // createFile("src\jsonText\Accident.json"); 1 º Parametro

        // FileWriter fWriter = new FileWriter("Accident.json"); 2 º Parametro
        
        FileWriter fWriter = new FileWriter(path2);
        System.out.println(events.toJSONString());
        fWriter.write(events.toJSONString());
        fWriter.close();

    }
    
    public String convertToJsonString(Event[] event) throws IOException {
        JSONObject accident = new JSONObject();
        JSONObject accidentEvent = new JSONObject();
        JSONArray events = new JSONArray();

        for (int i = 0; i < event.length; i++) {
            if (event[i] != null && event[i] instanceof EmployeeAccident ) {
                accident.put("groupname","Grupo21");
                accident.put("groupkey","xptoififirieidifie");
                accidentEvent.put("priority", event[i].getPriority().toString());
                accidentEvent.put("title", event[i].getTitle());
                accidentEvent.put("data",event[i].getDate().toString());
                accidentEvent.put("uuid",event[i].getUuid());
                accidentEvent.put("eventtype","Accident");
                accident.put("event",accidentEvent);
                events.add(accident);

            }else if(event[i] != null && event[i] instanceof EquipmentFailure){
                accident.put("groupname","Grupo21");
                accident.put("groupkey","xptoififirieidifie");
                accidentEvent.put("priority", event[i].getPriority().toString());
                accidentEvent.put("title", event[i].getTitle());
                accidentEvent.put("data",event[i].getDate().toString());
                accidentEvent.put("uuid",event[i].getUuid());
                accident.put("event",accidentEvent);
                accidentEvent.put("eventtype","Failure");
                events.add(accident);
            }
        }
        return events.toString();
    }

}
