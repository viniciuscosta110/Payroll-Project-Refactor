package Functionalities;

import static Classes.Payroll.*;
import java.util.LinkedList;
import java.util.Scanner;

import Classes.*;

public class PaymenteFunction {
  Scanner input = new Scanner(System.in);

  public void rollPayment(LinkedList<Employee> employees, LinkedList<Syndicate> syndicates, PaymentSchedule paymentSchedule) {
    verifyPayment(employees, syndicates, paymentSchedule);

    System.out.println("Pagamentos Efetuados");
    System.out.println("Pressione Enter para continuar");
    input.nextLine();
  }
}
