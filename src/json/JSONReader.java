/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package json;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Nome: José Miguel Pinto de Sousa Número: 8200689 Turma: LEI
 *
 * Nome: Ricardo Moreira da Fonte Número: 8200520 Turma: LSIRC
 */
public class JSONReader {

    File input = new File("AccidentEvent.json");

   
        try {
            JsonElement fileElement = JSONParser.parseReader(new FileReader(input));
        } catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }
   

}
