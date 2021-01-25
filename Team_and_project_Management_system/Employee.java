import java.util.ArrayList;

public class Employee implements Comparable<Employee> {
    private String name;
    private Team team = null;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Team getTeam() {
        return team;
    }

    public static Employee searchEmployee(ArrayList<Employee> list, String name){
        for(int i = 0 ; i<list.size(); i++) {
            if(list.get(i).getName().equals(name)) {
                return list.get(i);
            }
        }
        return null;
    }

    public int compareTo(Employee another){
        if(this.name.equals(another.name)){
            return 0;
        }else if(this.name.compareTo(another.name) > 0){
            return 1;
        }else {
            return -1;
        }
    }

    public void employeeJoinTeam(Team t) {
        this.team = t;
    }

    public void employeeLeaveTeam() {
        this.team = null;
    }

    public String getEmployeeTeamName() {
        if(team!=null) {
            return team.getTeamName();
        }
        return null;
    }



    
}
