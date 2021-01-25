public class CmdChangeTeam extends RecordedCommand {
    Company company = Company.getInstance();
    Team oldTeam;
    Team newTeam;
    Employee e;
    @Override
    public void execute(String[] cmdParts) {
        try {
            if (cmdParts.length < 3) {
                throw new ExInsufficientArgument();
            }
            if(company.findTeamName(cmdParts[2]) == false){
                throw new ExTeamDoesNotExist();
            }
            if(company.findEmployeeName(cmdParts[1]) == false){
                throw new ExEmployeeNameNotExist();
            }
            if(company.findEmployee(cmdParts[1]).getEmployeeTeamName().equals(cmdParts[2])){
                throw new ExOldTeamSameWithNewTeam();
            }
            e = company.findEmployee(cmdParts[1]);
            oldTeam = e.getTeam();
            e.employeeLeaveTeam();
            oldTeam.removeMembers(e);
            newTeam = company.findTeam(cmdParts[2]);
            e.employeeJoinTeam(newTeam);
            newTeam.addMembers(e);

            addUndoList(this);
            clearRedoList();

            System.out.println("Done. ");
        } catch (ExInsufficientArgument e) {
            System.out.println(e.getMessage());
        } catch (ExTeamDoesNotExist e) {
            System.out.println(e.getMessage());
        } catch (ExEmployeeNameNotExist e) {
            System.out.println(e.getMessage());
        } catch (ExOldTeamSameWithNewTeam e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void undoMe() {
        e.employeeJoinTeam(oldTeam);
        oldTeam.addMembers(e);
        newTeam.removeMembers(e);
        addRedoList(this);        
    }
    @Override
    public void redoMe() {
        e.employeeJoinTeam(newTeam);
        oldTeam.removeMembers(e);
        newTeam.addMembers(e);
        addUndoList(this);
    }
}
