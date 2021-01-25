public class CmdHire extends RecordedCommand {
    Company company = Company.getInstance();
    Employee e;
    @Override
    public void execute(String cmdParts[]) {
        try {
            if (cmdParts.length < 2) {
                throw new ExInsufficientArgument();
            }
            if(company.findEmployeeName(cmdParts[1])){
                throw new ExEmployeeNameAlreadyExist();
            }

            e = company.createEmployee(cmdParts[1]);
            addUndoList(this);
            clearRedoList();

            System.out.println("Done. ");
        } catch (ExInsufficientArgument e) {
            System.out.println(e.getMessage());
        } catch (ExEmployeeNameAlreadyExist e) {
            System.out.println(e.getMessage());
        }

    }
    @Override
    public void undoMe() {
        company.removeEmployee(e);
        addRedoList(this);
    }
    @Override
    public void redoMe() {
        company.addEmployee(e);
        addUndoList(this);
    }

}
