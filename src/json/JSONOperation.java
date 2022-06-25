/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package json;

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
 *
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

    public void exportEvent(Event[] event) throws IOException {
        JSONObject accident = new JSONObject();
        JSONObject accidentEvent = new JSONObject();
        JSONArray events = new JSONArray();
        
        for (int i = 0; i < event.length; i++) {
            accidentEvent.put("priority", event[i].getPriority());
            accidentEvent.put("title", event[i].getTitle());
            accident.put("event", event[i]);
            events.add(accident);
        }

        boolean iscreate = createFile("src\\jsonText\\Accident.json");

        if (iscreate) {
            FileWriter fWriter = new FileWriter("Accident.json");
            fWriter.write(events.toJSONString());
            fWriter.close();
        }
    }

}
