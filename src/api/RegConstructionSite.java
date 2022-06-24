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
import estgconstroi.Team;
import estgconstroi.enums.EquipmentStatus;
import estgconstroi.enums.EquipmentType;
import estgconstroi.exceptions.ConstructionSiteException;
import java.time.LocalDate;

/**
 *
 * @author phrea
 */
public class RegConstructionSite implements ConstructionSite {

    private final int MAX = 100;
    private int count = 0;
    /**
     * name of the construction site
     */
    private String name;

    /**
     * location of the construction site
     */
    private String location;

    /**
     * permit of the construction site
     */
    private String permit;

    /**
     * name of the team given to the construction site
     */
    private Team[] teamName = new Team[MAX];

    /**
     * license date of the construction permit
     */
    /**
     * responsible that handles the shipyard
     */
    private Employee responsible;

    private LocalDate license;


    public RegConstructionSite(String name, String location, String permit, LocalDate license, Employee responsible) {
        this.name = name;
        this.location = location;
        this.permit = permit;
        this.license = license;
        this.responsible = responsible;
        this.teamName = new Team[MAX];
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getLocation() {
        return this.location;
    }

    @Override
    public String getPermit() {
        return this.permit;
    }

    @Override
    public LocalDate getPermitExpirationDate() {
        return this.license;
    }

    @Override
    public void setPermit(String string, LocalDate ld) {
        this.permit = string;
        this.license = ld;
    }

    @Override
    public Employee getResponsible() {
        return this.responsible;
    }

    @Override
    public void setResponsible(Employee empl) throws ConstructionSiteException {
        this.responsible = empl;
    }

    @Override
    public void addTeam(Team team) throws ConstructionSiteException {

        if (this.teamName.length == this.MAX) {
            increaseTeamArraySize();
        }
        if (team.getName() == null) {
            this.teamName[this.count++] = team;
        } else {
            throw new ConstructionSiteException("Team`s name already exists");
        }

    }

    private int findTeam(Team team) {

        if (team == null) {
            return -1;
        }
        if (team instanceof Team) {
            for (int i = 0; i < count; i++) {
                if (this.teamName[i].equals(team)) {
                    return i;
                }
            }
        } else {
            return -1;
        }
        return -1;
    }

    @Override
    public void removeTeam(Team team) throws ConstructionSiteException {

        if (findTeam(team) != -1) {
            for (int i = findTeam(team); i < this.count - 1; i++) {
                this.teamName[i] = this.teamName[i++];
                this.count--;
            }
        } else {
            throw new ConstructionSiteException("Cannot remove team");
        }
    }

    @Override
    public Team[] getTeams(String string) {

        for (int i = 0; i < this.teamName.length; i++) {
            if (this.teamName[i].getName().equals(string)) {

                //System.out.println(this.teamName[i].getName());
                // getTeam(this.teamName[i])
            }
        }

        return null;

        //getTeam(this.teamName[i])
    }

    private Team[] getTeam(Team t) {
        Team[] temp = new Team[this.teamName.length];

        for (int i = 0; i < temp.length; i++) {
            temp[i] = t;
        }

        return null;
    }

    @Override
    public Team[] getTeams() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addEquipment(Equipment eqpmnt) throws ConstructionSiteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removeEquipment(Equipment eqpmnt) throws ConstructionSiteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Equipment[] getEquipment(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Equipment[] getEquipment(EquipmentStatus es) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Equipment[] getEquipment(EquipmentType et) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Equipment[] getEquipment() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isValid() {

        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * method to increase the size of the Team's array
     */
    public void increaseTeamArraySize() {
        Team[] temp = new Team[teamName.length * 2];

        for (int i = 0; i < teamName.length; i++) {
            temp[i] = teamName[i];
        }
        teamName = temp;
    }

}
