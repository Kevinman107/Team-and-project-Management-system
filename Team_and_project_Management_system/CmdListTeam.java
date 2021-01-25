public class CmdListTeam implements Command{

    Company company = Company.getInstance();
    @Override
    public void execute(String[] cmdParts) {
        company.listTeams();
    }


}
