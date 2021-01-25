public class ExEstManPower extends Exception{

    private static final long serialVersionUID = 1L;

    public ExEstManPower() {
        super("Estimated manpower should not be zero or negative.");
    }

    public ExEstManPower(String message) {
        super(message);
    }
}
