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
import estgconstroi.enums.EmployeeType;
import estgconstroi.Team;
import estgconstroi.enums.EquipmentStatus;
import estgconstroi.enums.EquipmentType;
import estgconstroi.exceptions.ConstructionSiteException;
import java.time.LocalDate;


public class RegConstructionSite implements ConstructionSite {

    /**
     * count for arrays
     */
    private final int MAX = 100;
    private int count = 0;
    private int countEquipment = 0;
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
     * array with the team`s given to the construction site
     */
    private Team[] teams = new Team[MAX];

    /**
     * array with the equipments of an construction site
     */
    private Equipment[] equipments = new Equipment[countEquipment];

    /**
     * license date of the construction permit
     */
    private LocalDate license;

    /**
     * responsible that handles the shipyard
     */
    private Employee responsible;

    public RegConstructionSite(String name, String location, String permit, LocalDate license, Employee responsible) {
        this.name = name;
        this.location = location;
        this.permit = permit;
        this.license = license;
        this.responsible = responsible;
        this.teams = new Team[MAX];
        this.equipments = new Equipment[countEquipment];

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

        if (this.teams.length == this.MAX) {
            increaseTeamArraySize();
        }
        for (int i = 0; i < this.teams.length; i++) {
            if (team.getName().equals(this.teams[i].getName())) {
                throw new ConstructionSiteException("Team`s name already exists");
            }
        }
        this.teams[this.count++] = team;

    }

    private int findTeam(Team team) {

        if (team == null) {
            return -1;
        }
        if (team instanceof Team) {
            for (int i = 0; i < this.count; i++) {
                if (this.teams[i].equals(team)) {
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
                this.teams[i] = this.teams[i++];
                this.count--;
            }
        } else {
            throw new ConstructionSiteException("Cannot remove team");
        }
    }

    @Override
    public Team[] getTeams(String string) {
        Team[] name = new Team[teams.length];
        int j = 0;

        for (int i = 0; i < this.teams.length; i++) {
            if (teams[i].getName().equals(getTeams(string))) {
                name[j++] = teams[i];
            }
        }
        System.out.println("Operation successful.");
        return name;
    }

    @Override
    public Team[] getTeams() {
        return this.teams;
    }

    private int findEquipment(Equipment eqpmnt) {

        if (eqpmnt == null) {
            return -1;
        }
        if (eqpmnt instanceof Equipment) {
            for (int i = 0; i < this.countEquipment; i++) {
                if (this.equipments[i].equals(eqpmnt)) {
                    return i;
                }
            }
        } else {
            return -1;
        }
        return -1;
    }

    @Override
    public void addEquipment(Equipment eqpmnt) throws ConstructionSiteException {

        if (findEquipment(eqpmnt) != -1) {
            for (int i = findEquipment(eqpmnt); i < this.countEquipment - 1; i++) {
                this.equipments[i] = this.equipments[i++];
                this.countEquipment--;
            }
        } else {
            throw new ConstructionSiteException("Equipment is already in the construction site");
        }
    }

    @Override
    public void removeEquipment(Equipment eqpmnt) throws ConstructionSiteException {
        if (eqpmnt instanceof Equipment) {
            for (int i = 0; i < this.equipments.length; i++) {
                if (this.equipments[i] == eqpmnt) {
                    throw new ConstructionSiteException("Equipment is not in the construction site");
                }
            }

        } else {
            throw new ConstructionSiteException("Equipment is not in the construction site");
        }
    }

    @Override
    public Equipment[] getEquipment(String string) {
        Equipment[] temp = new Equipment[this.equipments.length];
        count = 0;
        for (Equipment equipment : this.equipments) {
            if (equipment.getName().equals(string)) {
                temp[count] = equipment;
                count++;
            }
        }
        return temp;
    }

    @Override
    public Equipment[] getEquipment(EquipmentStatus es) {
        Equipment[] temp = new Equipment[this.equipments.length];
        count = 0;
        for (Equipment equipment : this.equipments) {
            if (equipment.getStatus().equals(es)) {
                temp[count] = equipment;
                count++;
            }
        }
        return temp;
    }

    @Override
    public Equipment[] getEquipment(EquipmentType et) {
        Equipment[] temp = new Equipment[this.equipments.length];
        count = 0;
        for (Equipment equipment : this.equipments) {
            if (equipment.getType().equals(et)) {
                temp[count] = equipment;
                count++;
            }
        }
        return temp;
    }

    @Override
    public Equipment[] getEquipment() {
        return this.equipments;
    }

    @Override
    public boolean isValid() {
        count = 0;
        if (getResponsible().getType().equals(EmployeeType.MANAGER)) {
            if (getTeams().length >= 1) {
                for (int i = 0; i < this.teams.length; i++) {
                    if (this.teams[i].equals(EmployeeType.TEAM_LEADER)) {
                        count += 1;
                    }
                }
                if (count == this.teams.length) {
                    for (int i = 0; i < this.equipments.length; i++) {
                        if (this.equipments[i].getStatus().equals(EquipmentStatus.OPERATIVE)) {
                            if(LocalDate.now().compareTo(this.license)>0){
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;

    }

    /**
     * method to increase the size of the Team's array
     */
    public void increaseTeamArraySize() {
        Team[] temp = new Team[teams.length * 2];

        for (int i = 0; i < teams.length; i++) {
            temp[i] = teams[i];
        }
        teams = temp;
    }

    /**
     * method to increase the size of the Equipment's array
     */
    public void increaseEquipmentArraySize() {
        Equipment[] temp = new Equipment[equipments.length * 2];

        for (int i = 0; i < equipments.length; i++) {
            temp[i] = equipments[i];
        }
        equipments = temp;
    }

}