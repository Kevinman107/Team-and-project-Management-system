public class ExOldTeamSameWithNewTeam  extends Exception{

    private static final long serialVersionUID = 1L;

    public ExOldTeamSameWithNewTeam() {
        super("The old and new teams should not be the same.");
    }

    public ExOldTeamSameWithNewTeam(String message) {
        super(message);
    }
}
