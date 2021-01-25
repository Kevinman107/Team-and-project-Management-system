public class ExProjectCodeAlreadyExist extends Exception {
   
    private static final long serialVersionUID = 1L;

    public ExProjectCodeAlreadyExist() {
        super("Project code already exists.");
    }

    public ExProjectCodeAlreadyExist(String message) {
        super(message);
    }
}
