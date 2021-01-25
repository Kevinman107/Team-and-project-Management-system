public class CmdJoinTeam extends RecordedCommand {
    Company company = Company.getInstance();
    Employee e;
    Team team;
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
            if((company.findEmployee(cmdParts[1])).getTeam() != null){
                throw new ExEmployeeJoinAnotherTeam();
            }


            e = company.findEmployee(cmdParts[1]);
            team = company.findTeam(cmdParts[2]);
            e.employeeJoinTeam(team);

            team.addMembers(e);

            addUndoList(this);
            clearRedoList();

            System.out.println("Done. ");
        } catch (ExInsufficientArgument e) {
            System.out.println(e.getMessage());
        } catch (ExEmployeeJoinAnotherTeam e) {
            System.out.println(e.getMessage());
        } catch (ExTeamDoesNotExist e) {
            System.out.println(e.getMessage());
        } catch (ExEmployeeNameNotExist e) {
            System.out.println(e.getMessage());
        }
    } 
    @Override
    public void undoMe() {
        e.employeeLeaveTeam();
        team.removeMembers(e);
        addRedoList(this);
    }
    @Override
    public void redoMe() {
        e.employeeJoinTeam(team);
        team.addMembers(e);
        addUndoList(this);
    }
    
}
