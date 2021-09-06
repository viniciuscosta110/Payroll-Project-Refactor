package Functionalities;

import java.util.LinkedList;
import java.util.Scanner;

import Classes.*;

public class TimeCardFunctions {
  Scanner input = new Scanner(System.in);
  
  public void addTimeCard(LinkedList<Employee> employees) {
    Hourly employee = new Hourly();
    TimeCard timecard = new TimeCard();

    int arrive_time;
    int departure_time;
    int uniqueID;
    int worked_day_time;
    String date;

    System.out.println("Insira o ID do funcionário\n\n");
    uniqueID = input.nextInt();
    input.nextLine();

    Boolean flag = true;
    Boolean hourly = true;

    for (Employee employee2 : employees) {
      if(employee2.getUniqueID() == uniqueID) {
        if(employee2.getPaymentType() == "Horista") {
          flag = false;
          hourly = false;
        }
      }
    }

    if(flag) {
      if(hourly) {
        System.out.println("\nEsse funcionário não é horista!\n");
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

    System.out.println("Data: (DD/MM/AA)");
    date = input.nextLine();

    System.out.println("Horário de entrada: (24h)");
    arrive_time = input.nextInt();
    input.nextLine();

    System.out.println("Horário de saida: (24h)");
    departure_time = input.nextInt();
    input.nextLine();

    for (Employee employee2 : employees) {
      if(employee2.getUniqueID() == uniqueID) {
        employee = (Hourly)(employee2);
        break;
      }
    }

    worked_day_time = departure_time - arrive_time;

    timecard = new TimeCard(arrive_time, departure_time, date);
    timecard.setWorked_day_time(worked_day_time);

    employee.setTimeCard(timecard);
  }
}
