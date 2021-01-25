public class CmdCreateProject extends RecordedCommand {
    Company company = Company.getInstance();
    Project project;
    @Override
    public void execute(String[] cmdParts) {

        try {
            if (cmdParts.length < 3) {
                throw new ExInsufficientArgument();
            }
            if (company.findProjectCode(cmdParts[1])){
                throw new ExProjectCodeAlreadyExist();
            }
            if(Integer.parseInt(cmdParts[2]) <= 0) {
                throw new ExEstManPower();
            }

            project = company.createProject(cmdParts[1], Integer.parseInt(cmdParts[2]));
            addUndoList(this);
            clearRedoList();

            System.out.println("Done. ");
        } catch (NumberFormatException e) {
            System.out.println("Wrong number format -- Please enter an integer.");
        } catch (ExInsufficientArgument e) {
            System.out.println(e.getMessage());
        } catch (ExProjectCodeAlreadyExist e) {
            System.out.println(e.getMessage());
        } catch (ExEstManPower e) {
            System.out.println(e.getMessage());
            System.out.println("Consider changing " + cmdParts[2] + " to a positive non-zero amount.");
        }
    }
    @Override
    public void undoMe() {
        company.removeProject(project);
        addRedoList(this);
    }
    @Override
    public void redoMe(){
        company.addProject(project);
        addUndoList(this);
    }
}
