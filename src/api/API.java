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
import estgconstroi.enums.EmployeeType;
import java.io.IOException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        
        Worker e1 = new Worker("Veracio", EmployeeType.MANAGER,uuid.randomUUID().toString());
        
        // System.out.println(uuid.randomUUID());
        
        System.out.println(e1);
        
     

    }
    
}
