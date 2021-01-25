public class ExEmployeeNameAlreadyExist extends Exception{


    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public ExEmployeeNameAlreadyExist() {
        super("Employee name already exists.");
    }

    public ExEmployeeNameAlreadyExist(String message) {
        super(message);
    }
}
