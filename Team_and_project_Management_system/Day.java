public class Day implements Cloneable{

    private int year;
    private int month;
    private int day;

    private static final String MonthNames = "JanFebMarAprMayJunJulAugSepOctNovDec";

    // Constructor
    public Day(int y, int m, int d) {
        this.year = y;
        this.month = m;
        this.day = d;
    }

    public Day(String sDay) {
        set(sDay);
    }

    public void set(String sDay) {
        String[] sDayParts = sDay.split("-");
        this.day = Integer.parseInt(sDayParts[0]);
        this.month = MonthNames.indexOf(sDayParts[1]) / 3 + 1;
        this.year = Integer.parseInt(sDayParts[2]);
    }

    // check if a given year is a leap year
    static public boolean isLeapYear(int y) {
        if (y % 400 == 0)
            return true;
        else if (y % 100 == 0)
            return false;
        else if (y % 4 == 0)
            return true;
        else
            return false;
    }

    // check if y,m,d valid
    static public boolean valid(int y, int m, int d) {
        if (m < 1 || m > 12 || d < 1)
            return false;
        switch (m) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return d <= 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return d <= 30;
            case 2:
                if (isLeapYear(y))
                    return d <= 29;
                else
                    return d <= 28;
        }
        return false;
    }

    // Return a string for the day like dd MMM yyyy
    @Override
    public String toString() {
        return day + "-" + MonthNames.substring((month - 1) * 3, (month) * 3) + "-" + year; // (month-1)*3,(month)*3
    }

    @Override
    public Day clone() {
        Day copy = null;
        try {
            copy = (Day) super.clone();
        } catch (CloneNotSupportedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return copy;
    }

    public int getYear() {
        return year;
    }

    public int getMonth(){
        return month;
    }

    public int getDay(){
        return day;
    }

    static public boolean checkValidDay (String sDay) {
        String[] dayParts = sDay.split("-");

        if(dayParts.length < 3) {
            return false;
        }
        if(dayParts[1].equals("Jan") || dayParts[1].equals("Feb") || dayParts[1].equals("Mar") ||dayParts[1].equals("Apr") || dayParts[1].equals("May") ||dayParts[1].equals("Jun") ||dayParts[1].equals("Jul") ||dayParts[1].equals("Aug") ||dayParts[1].equals("Sep") ||dayParts[1].equals("Oct") ||dayParts[1].equals("Nov") ||dayParts[1].equals("Dec")){
            int d1 = Integer.parseInt(dayParts[0]);
            int m1 = MonthNames.indexOf(dayParts[1]) / 3 + 1;
            int y1 = Integer.parseInt(dayParts[2]);
            if(valid(y1, m1, d1)) {
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }
}
