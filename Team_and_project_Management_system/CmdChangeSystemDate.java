
public class CmdChangeSystemDate extends RecordedCommand {
    SystemDate oldSystemDate;
    String systemDateStr;
    @Override
    public void execute(String[] cmdParts) {
        oldSystemDate = SystemDate.changeDateInstance(cmdParts[1]);
        systemDateStr = cmdParts[1];
        addUndoList(this);
        clearRedoList();
        System.out.println("Done. ");

    }
    @Override
    public void undoMe() {
        SystemDate.changeDateInstance(oldSystemDate.toString());
        addRedoList(this);
    }
    @Override
    public void redoMe() {
        SystemDate.changeDateInstance(systemDateStr);
        addUndoList(this);
    }
}
