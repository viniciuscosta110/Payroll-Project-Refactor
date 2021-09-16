package Functionalities;

import java.util.LinkedList;

import Classes.*;

public class ListEmployees {

  public static void listAllEmployees(LinkedList<Employee> employees) {
    System.out.println("Lista de Funcionários\n");

    if(employees.size() > 0) {
      for (Employee employee : employees) {
        if(employee.getPaymentType() == "Assalariado" || employee.getPaymentType() == "Assalariado comissionado") {
          Salaried aux = (Salaried) employee;
          System.out.println(aux.printEmployee());
        }
        else if(employee.getPaymentType() == "Horista") {
          Hourly aux = (Hourly) employee;
          System.out.println(aux.printEmployee());
        }
      }
      
      System.out.println("\nPressione Enter para continuar");
    }
    else {
      System.out.println("\nLista Vazia\n");
      System.out.println("\nPressione Enter para continuar");
    }
  }
}
