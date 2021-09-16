package Classes.History;

import java.util.ArrayList;

import Classes.States;

public class NullHistoryHandler implements HistoryHandlerInterface {

  public int getHead() {
    return 0;
  }
  
  public ArrayList<States> getStates() {
    return null;
  }

  public States undo(){
    return null;
  }

  public States redo() {
    return null;
  }
}
