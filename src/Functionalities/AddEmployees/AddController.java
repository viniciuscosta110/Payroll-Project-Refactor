package Functionalities.AddEmployees;

import Classes.Employee;

public class AddController {
  Command slot;

  public void setSlot(Command slot) {
    this.slot = slot;
  }

  public Employee execute() {
    return this.slot.add();
  }
}
