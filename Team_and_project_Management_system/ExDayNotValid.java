public class ExDayNotValid extends Exception {
    
    private static final long serialVersionUID = 1L;

    public ExDayNotValid() {
        super("Invalid date.");
    }

    public ExDayNotValid(String message) {
        super(message);
    }
}
