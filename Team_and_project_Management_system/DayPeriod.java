public class DayPeriod{
    Day startDay;
    Day endDay;
    private static final String MonthNames = "JanFebMarAprMayJunJulAugSepOctNovDec";


    public DayPeriod(String startDay, int totalDate) {
        this.startDay = new Day(startDay);
        String[] startDayParts = startDay.split("-");

        int endDayYear = Integer.parseInt(startDayParts[2]);
        int endDayMonth = MonthNames.indexOf(startDayParts[1]) / 3 + 1;
        int endDayDay = Integer.parseInt(startDayParts[0]);

        for(int i = 0  ; i<totalDate-1; i++) {
            
        
            if(endDayMonth == 12 && endDayDay == 31){
                endDayMonth = 1;
                endDayDay = 1;
                endDayYear +=1;
                continue;
            }


            if(Day.valid(endDayYear, endDayMonth, endDayDay + 1)){
                endDayDay += 1;
            }else{
                endDayDay = 1;
                endDayMonth += 1;
            }
        
        }

        this.endDay = new Day(endDayYear, endDayMonth, endDayDay);

    }

    public Day getStartDay() {
        return startDay;
    }

    public Day getEndDay() {
        return endDay;
    }

    public static boolean compareTodayDate(String day1) {
        Day systemDate = SystemDate.getInstance().clone();
        String[] str = day1.split("-");

        int testDayYear = Integer.parseInt(str[2]);
        int testDayMonth = MonthNames.indexOf(str[1]) / 3 + 1;
        int testDayDay = Integer.parseInt(str[0]);

        int testDay = testDayYear * 10000 + testDayMonth * 100 + testDayDay;
        int systemDateint = systemDate.getYear() * 10000 + systemDate.getMonth() * 100 + systemDate.getDay();

        if(testDay > systemDateint) {
            return true;
        }else{
            return false;
        }
    }

    public boolean compareOverLap(String testDay, Team t, int totaldate) {
        String[] str = testDay.split("-");
        boolean istheFirst = true;
        if(istheFirst == true){
            int testDayYear = Integer.parseInt(str[2]);
            int testDayMonth = MonthNames.indexOf(str[1]) / 3 + 1;
            int testDayDay = Integer.parseInt(str[0]);
            int testDayint = testDayYear * 10000 + testDayMonth * 100 + testDayDay;
            for(int i = 0 ; i<t.getDayPeroid().size(); i++) {
                int startDayint = t.getDayPeroid().get(i).getStartDay().getYear() * 10000 + t.getDayPeroid().get(i).getStartDay().getMonth() * 100 +
                t.getDayPeroid().get(i).getStartDay().getDay();
                int endDayint = t.getDayPeroid().get(i).getEndDay().getYear() * 10000 + t.getDayPeroid().get(i).getEndDay().getMonth() * 100 + 
                t.getDayPeroid().get(i).getEndDay().getDay();
        
                if(testDayint >= startDayint && testDayint <= endDayint) {
                    return false;
                }
            }
            istheFirst = false;
        }
        for(int j =0  ;j < totaldate; j++) {

            int testDayYear = Integer.parseInt(str[2]);
            int testDayMonth = MonthNames.indexOf(str[1]) / 3 + 1;
            int testDayDay = Integer.parseInt(str[0]);
            
            if(testDayMonth == 12 && testDayDay == 31){
                testDayMonth = 1;
                testDayDay = 1;
                testDayYear +=1;
                continue;
            }
            if(Day.valid(testDayYear, testDayMonth, testDayDay + 1)){
                testDayDay += 1;
            }else{
                testDayDay = 1;
                testDayMonth += 1;
            }

            int testDayint = testDayYear * 10000 + testDayMonth * 100 + testDayDay;

            for(int i = 0 ; i<t.getDayPeroid().size(); i++) {
                int startDayint = t.getDayPeroid().get(i).getStartDay().getYear() * 10000 + t.getDayPeroid().get(i).getStartDay().getMonth() * 100 +
                t.getDayPeroid().get(i).getStartDay().getDay();
                int endDayint = t.getDayPeroid().get(i).getEndDay().getYear() * 10000 + t.getDayPeroid().get(i).getEndDay().getMonth() * 100 + 
                t.getDayPeroid().get(i).getEndDay().getDay();
        
                if(testDayint >= startDayint && testDayint <= endDayint) {
                    return false;
                }
            }
        }
        return true;
    }

    

}
