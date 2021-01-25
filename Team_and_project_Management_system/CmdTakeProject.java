public class CmdTakeProject extends RecordedCommand {
    Company company = Company.getInstance();
    Team t;
    Project p;
    DayPeriod dayPeriod;
    @Override
    public void execute(String[] cmdParts) {

        try {
            if (cmdParts.length < 4) {
                throw new ExInsufficientArgument();
            }
            
            if(company.findTeamName(cmdParts[1]) == false){
                throw new ExTeamDoesNotExist();
            }

            if(company.findProjectCode(cmdParts[2]) == false) {
                throw new ExProjectDoesNotExist();
            }

            if(company.findProject(cmdParts[2]).getTeam() != null) {
                throw new ExProjectAlreadyAssign();
            }

            if(!Day.checkValidDay(cmdParts[3])) {
                throw new ExDayNotValid();
            }
           
            if (!DayPeriod.compareTodayDate(cmdParts[3])) {
                throw new ExBeforeTomorrow();
            }

            


            t = company.findTeam(cmdParts[1]);
            p = company.findProject(cmdParts[2]);

            int totalDate = (int) Math.ceil(((float) p.getEstManPower() / t.numberOfMembers()));

            dayPeriod = new DayPeriod(cmdParts[3], totalDate);

            if(!dayPeriod.compareOverLap(cmdParts[3], t, totalDate)){
                throw new ExDateOverLap();
            }
            p.setDayPeriod(dayPeriod);
            p.assignTeam(t);

            addUndoList(this);
            clearRedoList();

            t.addDayPeriod(dayPeriod);

            System.out.println("Done. ");
        } catch (ExInsufficientArgument e) {
            System.out.println(e.getMessage());
        } catch (ExBeforeTomorrow e) {
            System.out.println(e.getMessage());
        } catch (ExTeamDoesNotExist e) {
            System.out.println(e.getMessage());
        } catch (ExProjectDoesNotExist e) {
            System.out.println(e.getMessage());
        } catch (ExProjectAlreadyAssign e) {
            System.out.println(e.getMessage());
        } catch (ExDateOverLap e) {
            System.out.println("The team is not available during the period (" + dayPeriod.startDay.toString() + " to " + dayPeriod.endDay.toString() + ")."); 
        } catch (ExDayNotValid e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void undoMe() {
        p.removeTeam();
        p.removeDayPeriod();
        addRedoList(this);
    }
    @Override
    public void redoMe() {
        p.setDayPeriod(dayPeriod);
        p.assignTeam(t);
        addUndoList(this);
    }


}
