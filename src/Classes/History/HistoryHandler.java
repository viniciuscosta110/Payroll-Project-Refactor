package Classes.History;

import java.util.ArrayList;

import Classes.States;

public class HistoryHandler implements HistoryHandlerInterface {
  int head = 0;
  States newState = new States();
  ArrayList<States> states = new ArrayList<>();

  public ArrayList<States> getStates() {
    return states;
  }
  
  public int getHead() {
    return head;
  }

  public States undo(){
    newState = states.get(head);
    
    if(this.head == 0) {
      System.out.println("Não há estado anterior.");
    }
    else {
      System.out.println("Alteração desfeita");
      this.head--;
      newState =  states.get(head);
    }

    return newState;
  }

  public States redo(){
    newState = states.get(head);

    if(this.head >= this.states.size() - 1) {
      System.out.println("Não há estado posterior.");
    }
    else {
      System.out.println("Alteração refeita");
      this.head++;
      newState =  states.get(head);
    }

    return newState;
  }

  public HistoryHandler(int head, ArrayList<States> states){
    this.head = head;
    this.states = states;
  }
}
