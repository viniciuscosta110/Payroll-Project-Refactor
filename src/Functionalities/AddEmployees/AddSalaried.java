package Functionalities.AddEmployees;

import java.util.LinkedList;
import java.util.Scanner;

import static Classes.EmployeeCreator.*;
import Classes.*;

public class AddSalaried implements Command {
  Scanner input = new Scanner(System.in);
  LinkedList<Syndicate> syndicates;

  public LinkedList<Syndicate> getSyndicates() {
    return syndicates;
  }
  
  public Employee add() {
    Salaried employee = new Salaried();

    String paymentType = "";
    int paymentSchedule;
    String commissioned;
    String monthSalary;
    Double commission = 0.0;

    AddEmployee ae = new AddEmployee();
    ae.inCommon(employee, syndicates);

    String name = employee.getName();
    String address = employee.getAddress();
    int uniqueID = employee.getUniqueID();
    String paymentWay = employee.getPaymentWay();

    System.out.print("\nSalário Mensal: ");
    monthSalary = input.nextLine();

    System.out.print("Comissionado (Digite Sim ou Nao): ");
    commissioned = input.nextLine();

    if(commissioned.toLowerCase().equals("sim")) {
      System.out.print("Comissão (Digite um número para representar a porcentagem): ");
      commission = input.nextDouble();
      input.nextLine();

      paymentType = "Assalariado comissionado";
      paymentSchedule = 2;
    }
    else {
      paymentType = "Assalariado";
      paymentSchedule = 0;
    }

    employee = createSalaried(name, address, uniqueID, paymentSchedule, paymentType, paymentWay, Double.parseDouble(monthSalary), commission);
    
    return employee;
  }

  public AddSalaried(LinkedList<Syndicate> syndicates) {
    this.syndicates = syndicates;
  }
}
