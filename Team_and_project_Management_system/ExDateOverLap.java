public class ExDateOverLap extends Exception {
   
    private static final long serialVersionUID = 1L;

    public ExDateOverLap() {
        super("The earliest start day is tomorrow.");
    }

    public ExDateOverLap(String message) {
        super(message);
    }
}
