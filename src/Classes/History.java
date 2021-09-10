package Classes;

import java.util.*;

public class History {
  ArrayList<States> states = new ArrayList<>();
  int head = 1;
  Scanner input = new Scanner(System.in);

  public int getHead() {
    return head;
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

  public States undo() {
    States aux = null;
    
    if(this.head == 0) {
      System.out.println("Não há estado anterior.");
    }
    else {
      System.out.println("Alteração desfeita");
      this.head--;
      aux =  states.get(head);
    }

    System.out.println("Pressione Enter para continuar");
    input.nextLine();
    return aux;
  }

  public States redo() {
    States aux = null;
    
    if(this.head >= this.states.size() - 1) {
      System.out.println("Não há estado posterior.");
    }
    else {
      System.out.println("Alteração refeita");
      this.head++;
      aux =  states.get(head);
    }

    System.out.println("Pressione Enter para continuar");
    input.nextLine();
    return aux;
  }

  public History() {
    States initialState = new States(new PaymentSchedule(), new LinkedList<>(), new LinkedList<>(), 0, -1);
    this.setStates(initialState);
    this.head--;
  }
}
