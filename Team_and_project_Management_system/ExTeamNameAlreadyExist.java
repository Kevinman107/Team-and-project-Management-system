public class ExTeamNameAlreadyExist extends Exception{
    
    private static final long serialVersionUID = 1L;

    public ExTeamNameAlreadyExist() {
        super("Team name already exists.");
    }

    public ExTeamNameAlreadyExist(String message) {
        super(message);
    }
}
