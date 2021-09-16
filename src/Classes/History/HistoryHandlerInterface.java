package Classes.History;

import java.util.ArrayList;

import Classes.States;

public interface HistoryHandlerInterface {
  public States undo();
  public States redo();
  public ArrayList<States> getStates();
  public int getHead();
}
