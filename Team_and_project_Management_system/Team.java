import java.util.ArrayList;
import java.util.Collections;

public class Team implements Comparable<Team> {
    private String teamName;
    private Employee head;
    private Day dateSetup;
    private ArrayList<Employee> members;
    private ArrayList<DayPeriod> allDayPeriod = new ArrayList<>();

    public Team(String teamName, Employee headName) {
        this.teamName = teamName;
        this.head = headName;
        this.dateSetup = SystemDate.getInstance().clone();
        this.members = new ArrayList<>();
    }

    public static void list(ArrayList<Team> list) {
        System.out.printf("%-15s%-10s%-13s%-13s\n", "Team Name", "Leader", "Setup Date", "Members");
        
        
        for (Team t : list){
            if(t.members.size() == 0){
                System.out.printf("%-15s%-10s%-13s%-13s\n", t.teamName, t.head.getName(), t.dateSetup, "(no member)");
            }else {
                String memberStr = "";
                for(int i = 0 ; i<t.members.size(); i++) {
                    memberStr += t.members.get(i).getName() + " ";
                }
                System.out.printf("%-15s%-10s%-13s%-13s\n", t.teamName, t.head.getName(), t.dateSetup, memberStr);
            }

        }
    }

    public int compareTo(Team another) {
        if (this.teamName.equals(another.teamName)) {
            return 0;
        } else if (this.teamName.compareTo(another.teamName) > 0) {
            return 1;
        } else {
            return -1;
        }
    }

    public String getTeamName() {
        return teamName;
    }

    public String getTeamHeadName() {
        return head.getName();
    }

    public static Team searchTeam(ArrayList<Team> list, String name) {
        for(int i = 0 ; i<list.size();i++) {
            if(list.get(i).getTeamName().equals(name)){
                return list.get(i);
            }
        }
        return null;
    }

    public void addMembers(Employee e) {
        members.add(e);
        Collections.sort(members);
    }
    
    public void removeMembers(Employee e){
        members.remove(e);
    }

    public int numberOfMembers(){
        return members.size() + 1;
    }

    public void addDayPeriod(DayPeriod d) {
        allDayPeriod.add(d);
    }

    public ArrayList<DayPeriod> getDayPeroid (){
        return allDayPeriod;
    }

}
