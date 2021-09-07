package Functionalities;

import java.util.LinkedList;
import java.util.Scanner;

import Classes.*;

public class SaleFunctions {
  Scanner input = new Scanner(System.in);

  public void addSale(LinkedList<Employee> employees) {
    int uniqueID;
    Salaried employee = new Salaried();
    String date;
    Double price;
    Sale sale = new Sale();

    System.out.println("Insira o ID do funcionário\n\n");
    uniqueID = input.nextInt();
    input.nextLine();

    Boolean flag = true;
    Boolean salaried = true;

    for (Employee employee2 : employees) {
      if(employee2.getUniqueID() == uniqueID) {
        if(employee2.getPaymentType().contains("comissionado")) {
          flag = false;
          salaried = false;
          employee = (Salaried) employee2;
					break;
        }
      }
    }

    if(flag) {
      if(salaried) {
        System.out.println("\nEsse funcionário não é comissionado!\n");
        System.out.println("\nPressione Enter para continuar");
        input.nextLine();
      }
      else {
        System.out.println("\nEsse funcionário não está cadastrado!\n");
        System.out.println("\nPressione Enter para continuar");
        input.nextLine();
      }
      
      return;
    }

    System.out.print("\nData: ");
    date = input.nextLine();

    System.out.print("Preço: ");
    price = input.nextDouble();

    sale.setDate(date);
    sale.setPrice(price);

    employee.setSales(sale);

    employee.getSales();

    System.out.println("\nVenda cadastrada com sucesso!\n");
    System.out.println("\nPressione Enter para continuar");
    input.nextLine();
  }
}
