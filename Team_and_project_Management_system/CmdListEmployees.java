public class CmdListEmployees implements Command{
    Company company = Company.getInstance();
    @Override
    public void execute(String[] cmdParts){
        company.listEmployee();
    }
}
