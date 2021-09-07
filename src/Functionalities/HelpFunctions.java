package Functionalities;

import java.util.LinkedList;

import Classes.Employee;

public class HelpFunctions {

  public static void clear() {
    for (int i = 0; i < 20; i++) {
        System.out.println('\n');
    }
  }

  public static Employee findEmployee(LinkedList<Employee> employees, int id) {
    Employee employee2 = new Employee();
    for (Employee employee : employees) {
      if(employee.getUniqueID() == id)
      {
        employee2 = employee;
      }
    }

    return employee2;
  }
}
