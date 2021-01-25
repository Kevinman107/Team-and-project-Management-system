public class CmdSetupTeam extends RecordedCommand {
    Company company = Company.getInstance();
    Employee e;
    Team team;
    @Override
    public void execute(String[] cmdParts) {

        try {
            if (cmdParts.length < 3) {
                throw new ExInsufficientArgument();
            }
            if(company.findTeamName(cmdParts[1])){
                throw new ExTeamNameAlreadyExist();
            }
            if(company.findEmployeeName(cmdParts[2]) == false){
                throw new ExEmployeeNameNotExist();
            }
            if(company.findTeamLeaderName(cmdParts[2])){
                throw new ExEmployeeJoinAnotherTeam();
            }

            team = company.createTeam(cmdParts[1], cmdParts[2]);
            e = company.findEmployee(cmdParts[2]);
            e.employeeJoinTeam(team);
            addUndoList(this);
            clearRedoList();

            System.out.println("Done. ");
        } catch (ExInsufficientArgument e) {
            System.out.println(e.getMessage());
        }  catch (ExTeamNameAlreadyExist e) {
            System.out.println(e.getMessage());
        }  catch (ExEmployeeNameNotExist e) {
            System.out.println(e.getMessage());
        } catch (ExEmployeeJoinAnotherTeam e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void undoMe() {
        e.employeeLeaveTeam();
        company.removeTeam(team);
        
        addRedoList(this);
    }
    @Override
    public void redoMe() {
        company.addTeam(team);
        e.employeeJoinTeam(team);
        addUndoList(this);
    }
}
