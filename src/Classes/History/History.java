package Classes.History;

import java.util.*;

import Classes.PaymentSchedule;
import Classes.States;

public class History extends HistoryDefault {
  ArrayList<States> states = new ArrayList<>();
  int head = 0;
  Scanner input = new Scanner(System.in);

  public int getHead() {
    return head;
  }

  public void setHead(int head) {
    this.head = head;
  }
  
  public ArrayList<States> getStates() {
    return states;
  }

  public void setStates(ArrayList<States> states){
    this.states = states;
  }

  public void setStates(States state) {
    int i = 0;

    for (States state2 : states) {
      if(i > this.head) {
        states.remove(state2);
      }

      i++;
    }

    this.head++;
    this.states.add(state);
  }

  public History() {
    States initialState = new States(new PaymentSchedule(), new LinkedList<>(), new LinkedList<>(), 0, -1);
    this.setStates(initialState);
    this.head--;
  }
}
