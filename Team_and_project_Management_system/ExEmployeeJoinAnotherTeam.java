public class ExEmployeeJoinAnotherTeam extends Exception{

    private static final long serialVersionUID = 1L;

    public ExEmployeeJoinAnotherTeam() {
        super("Employee has joined a team already.");
    }

    public ExEmployeeJoinAnotherTeam(String message) {
        super(message);
    }
}
