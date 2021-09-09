package Functionalities;

import java.util.Scanner;
import java.util.LinkedList;

import Classes.*;

public class AddFee {
  Scanner input = new Scanner(System.in);

  public void newFee(LinkedList<Employee> employees, LinkedList<Syndicate> syndicates) {
    int uniqueID;
    Double service_fee;

    System.out.println("\nInsira o ID do funcionário\n");
    uniqueID = input.nextInt();
    input.nextLine();

    for (Syndicate syndicate : syndicates) {
      if(syndicate.getEmployeeId() == uniqueID) {
        System.out.println("\nDigite a taxa cobrada pelo serviço (R$): ");
        service_fee = input.nextDouble();
        input.nextLine();

        syndicate.setService_fee(service_fee);;
        System.out.println("\n\nTaxas cadastradas:\n");
        for (Syndicate syndicate3 : syndicates) {
          System.out.println(syndicate3.printSyndicate());
        }

        System.out.println("\nTaxa cadastrada com sucesso!\n");
        System.out.println("\nPressione Enter para continuar");
        input.nextLine();
        return;
      }
    }

    System.out.println("\nEsse funcionário não está no sindicato\n");
    System.out.println("\nPressione Enter para continuar");
    input.nextLine();
  }
}
