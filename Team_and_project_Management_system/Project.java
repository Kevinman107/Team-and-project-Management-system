import java.util.ArrayList;

public class Project implements Comparable<Project> {
    private String projectCode;
    private int estManPower;
    private Team team;
    private DayPeriod dayPeriod;

    public Project(String projectCode, int estManPower){
        this.projectCode = projectCode;
        this.estManPower = estManPower;
    }

    public static void list(ArrayList<Project> list) {
        System.out.printf("%-10s%-15s%-13s%-13s%-13s\n", "Project", "Est manpower", "Team", "Start Day", "End Day");

        for (Project p : list){
            if(p.team == null) {
                System.out.printf("%-10s%-15s%-13s\n", p.projectCode, p.estManPower + " man-days", "(Not Assigned)");

            }else {
                System.out.printf("%-10s%-15s%-13s%-13s%-13s\n", p.projectCode, p.estManPower + " man-days", p.team.getTeamName(), p.dayPeriod.getStartDay(), p.dayPeriod.getEndDay());
            }
        }
    }

    public int compareTo(Project another) {
        if (this.projectCode.equals(another.projectCode)) {
            return 0;
        } else if (this.projectCode.compareTo(another.projectCode) > 0) {
            return 1;
        } else {
            return -1;
        }
    }

    public String getProjectCode() {
        return projectCode;
    }

    public int getEstManPower() {
        return estManPower;
    }

    public Team getTeam() {
        return team;
    }

    public void assignTeam(Team t) {
        this.team = t;
    }

    public void removeTeam(){
        this.team = null;
    }

    public void setDayPeriod(DayPeriod dayPeriod) {
        this.dayPeriod = dayPeriod;
    }

    public void removeDayPeriod() {
        this.dayPeriod = null;
    }

}
