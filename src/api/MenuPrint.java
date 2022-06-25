/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api;

import estgconstroi.Employee;
import estgconstroi.Team;
import estgconstroi.Event;
import estgconstroi.enums.EmployeeType;
import java.util.Scanner;

/**
 * Nome: José Miguel Pinto de Sousa Número: 8200689 Turma: LEI
 *
 * Nome: Ricardo Moreira da Fonte Número: 8200520 Turma: LSIRC
 */
public class MenuPrint {

    private Scanner scanner;
    Worker empregado1 = new Worker("ze", EmployeeType.WORKER, "1");
    Worker empregado2 = new Worker("ricardo", EmployeeType.MANAGER, "2");
    Worker empregado3 = new Worker("carlos", EmployeeType.TEAM_LEADER, "3");
    Worker empregado4 = new Worker("jose", EmployeeType.WORKER, "4");

    public void menu() {

        int num = 0;

        System.out.println("Employee`s Manegement--->1");
        System.out.println("Team`s Manegement------->2");
        System.out.println("Events Manegement------->3");
        System.out.println("Operacao:");

        while (1 == 1) {
            String o = scanner.next();
            try {
                num = Integer.parseInt(o);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Insira um numero");
            }
        }

        switch (num) {
            case 1:
                employeesManegement();
                break;
            case 2:
                teamsManegement();
                break;
            default:
                eventsManegement();
                break;
        }

    }

    public void employeesManegement() {

        System.out.println("-----Employee`s Manegement-----");

    }

    public void teamsManegement() {

        System.out.println("-----Team`s Manegement-----");

       // Team team1 = new WorkersTeam("team1", empregado1);

    }

    public void eventsManegement() {

        System.out.println("-----Events Manegement-----");

    }

}
