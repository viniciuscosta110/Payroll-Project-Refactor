package Functionalities.AddEmployees;

import java.util.LinkedList;
import java.util.Scanner;

import Classes.*;

public class AddHourly implements Command{
  Scanner input = new Scanner(System.in);
  LinkedList<Syndicate> syndicates = new LinkedList<> ();

  public LinkedList<Syndicate> getSyndicates() {
    return syndicates;
  }

  public Employee add() {
    Hourly employee = new Hourly();
    String paymentType = "Horista";
    String hourSalary = "";
    int paymentSchedule = 1;

    AddEmployee ae = new AddEmployee();
    ae.inCommon(employee, syndicates);

    String name = employee.getName();
    String address = employee.getAddress();
    int uniqueID = employee.getUniqueID();
    String paymentWay = employee.getPaymentWay();

    System.out.print("\nSalário por hora: ");
    hourSalary = input.nextLine();

    employee = new Hourly(name, address, uniqueID, paymentSchedule, paymentType, paymentWay, Double.parseDouble(hourSalary));

    return employee;
  }

  public AddHourly(LinkedList<Syndicate> syndicates) {
    this.syndicates = syndicates;
  }
}
