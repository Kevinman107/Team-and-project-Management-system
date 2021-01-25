public class ExProjectAlreadyAssign extends Exception{

    private static final long serialVersionUID = 1L;

    public ExProjectAlreadyAssign() {
        super("Project has already been assigned to a team.");
    }

    public ExProjectAlreadyAssign(String message) {
        super(message);
    }
}
