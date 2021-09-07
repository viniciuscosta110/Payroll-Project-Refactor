package Functionalities;

import static Functionalities.HelpFunctions.*;

import java.util.LinkedList;
import java.util.Scanner;

import Classes.Employee;

public class RemoveEmployee {
  Scanner input = new Scanner(System.in);

  public void deleteEmployee(LinkedList<Employee> employees) {
    int id;

    System.out.println("Digite o ID do funcionário que deseja remover.");
    System.out.print("ID: ");

    id = input.nextInt();
    input.nextLine();

    Employee employee = findEmployee(employees, id);
    
    if(employee.getUniqueID() != 0) {
      employees.remove(employee);

      System.out.println("\nFuncionário removido.\n");
      System.out.println("\nPressione Enter para continuar.\n");
      input.nextLine();
      
      clear();
    }
    else {
      System.out.println("\nEsse funcionário não está cadastrado!\n");
      System.out.println("\nPressione Enter para continuar");
      input.nextLine();
    }
  }
}
