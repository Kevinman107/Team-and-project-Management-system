public class SystemDate extends Day{
    private static SystemDate theSystemDate;

    private SystemDate(String sDay) {
        super(sDay);
    }

    public static void createTheInstance(String sDay) {
        if(theSystemDate == null){
            theSystemDate = new SystemDate(sDay);
        }else {
            System.out.println("Cannot create one more system date instance.");
        }
    }

    public static SystemDate getInstance() {
        return theSystemDate;
    }

    public static SystemDate changeDateInstance(String sDay){
        SystemDate oldSystemDate = theSystemDate;
        theSystemDate = new SystemDate(sDay);
        return oldSystemDate;
    }
}
