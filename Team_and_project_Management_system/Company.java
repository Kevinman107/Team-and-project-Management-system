import java.util.ArrayList;
import java.util.Collections;

public class Company {
    private ArrayList<Employee> allEmployees;
    private ArrayList<Team> allTeams;
    private ArrayList<Project> allProjects;

    private static Company theCompany = new Company();

    private Company() {
        allEmployees = new ArrayList<>();
        allTeams = new ArrayList<>();   
        allProjects = new ArrayList<>();  
    }

    public static Company getInstance() {
        return theCompany;
    }

    public void listTeams() {
        Team.list(allTeams);
    }

    public void listProject() {
        Project.list(allProjects);
    }

    public Employee createEmployee(String name){
        Employee e = new Employee(name);
        allEmployees.add(e);
        Collections.sort(allEmployees);
        return e;
    }

    public Team createTeam(String teamName, String teamHead) {
        Employee e = Employee.searchEmployee(allEmployees, teamHead);
        Team t = new Team(teamName, e);
        allTeams.add(t);
        Collections.sort(allTeams);
        return t;
    }

    public void removeEmployee(Employee e) {
        allEmployees.remove(e);
    }

    public void addEmployee(Employee e) {
        allEmployees.add(e);
        Collections.sort(allEmployees);
    }

    public void listEmployee(){
        for(int i = 0 ; i<allEmployees.size(); i++) {
            if(allEmployees.get(i).getEmployeeTeamName() == null){
                System.out.println(allEmployees.get(i).getName());
            }else {
                System.out.println(allEmployees.get(i).getName() + " (" + allEmployees.get(i).getEmployeeTeamName() + ")");
            }
        }
    }

    public void removeTeam(Team t) {
        allTeams.remove(t);
    }
    
    public void addTeam(Team t){
        allTeams.add(t);
        Collections.sort(allTeams);
    }

    public Project createProject(String projectCode, int estManPower) {
        Project p = new Project(projectCode, estManPower);
        allProjects.add(p);
        Collections.sort(allProjects);
        return p;
    }

    public void removeProject(Project p){
        allProjects.remove(p);
    }

    public void addProject(Project p){
        allProjects.add(p);
        Collections.sort(allProjects);
    }

    public boolean findEmployeeName(String name){
        for(int i = 0 ; i<allEmployees.size();i++) {
            if(allEmployees.get(i).getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public boolean findTeamName(String name){
        for(int i = 0 ; i<allTeams.size();i++) {
            if(allTeams.get(i).getTeamName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public boolean findTeamLeaderName(String name){
        for(int i = 0 ; i<allTeams.size(); i++){
            if(allTeams.get(i).getTeamHeadName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public boolean findProjectCode(String projectCode){
        for(int i = 0 ; i<allProjects.size();i++) {
            if(allProjects.get(i).getProjectCode().equals(projectCode)){
                return true;
            }
        }
        return false;
    }

    public Project findProject(String projectCode){
        for(int i = 0 ; i<allProjects.size();i++) {
            if(allProjects.get(i).getProjectCode().equals(projectCode)){
                return allProjects.get(i);
            }
        }
        return null;
    }
    
    public Employee findEmployee(String name) {
        for(int i = 0 ; i<allEmployees.size(); i++) {
            if(allEmployees.get(i).getName().equals(name)){
                return allEmployees.get(i);
            }
        }
        return null;
    }

    public Team findTeam(String name) {
        return Team.searchTeam(allTeams, name);
    }

    public boolean employeeJoinedTeam(Employee e){
        if(e.getTeam() == null){
            return false;
        }else {
            return true;
        }
    }
    
}
