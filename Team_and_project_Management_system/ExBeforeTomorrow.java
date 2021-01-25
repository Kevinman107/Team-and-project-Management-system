public class ExBeforeTomorrow extends Exception{

    private static final long serialVersionUID = 1L;

    public ExBeforeTomorrow() {
        super("The earliest start day is tomorrow.");
    }

    public ExBeforeTomorrow(String message) {
        super(message);
    }
}
