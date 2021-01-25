import java.util.ArrayList;

public abstract class RecordedCommand implements Command {

    private static ArrayList<RecordedCommand> undoList = new ArrayList<>();
    private static ArrayList<RecordedCommand> redoList = new ArrayList<>();

    public abstract void undoMe();
    public abstract void redoMe();

    protected static void addUndoList(RecordedCommand cmd){
        undoList.add(cmd);
    }

    protected static void addRedoList(RecordedCommand cmd) {
        redoList.add(cmd);
    }

    protected static void clearRedoList() {
        redoList.clear();
    }

    public static void undoOneCommand() {
        if(undoList.size()>0) {
            undoList.remove(undoList.size()-1).undoMe();
        }else {
            System.out.println("Nothing to undo.");
        }
    }

    public static void redoOneCommand(){
        if(redoList.size() > 0) {
            redoList.remove(redoList.size()-1).redoMe();
        }else {
            System.out.println("Nothing to redo.");
        }
    }
}
