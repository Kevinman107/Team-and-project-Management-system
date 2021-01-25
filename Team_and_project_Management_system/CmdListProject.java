public class CmdListProject implements Command {
    Company company = Company.getInstance();
    @Override
    public void execute(String[] cmdParts) {
        company.listProject();
    }
}
