package Functionalities;

import java.util.Scanner;

import Classes.*;

public class AddNewSchedule {
  Scanner input = new Scanner(System.in);

  public void newSchedule(PaymentSchedule paymentSchedule) {
    String newOption = "";
    String[] weekDays = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY","FRIDAY"};
    int select;

    System.out.println("Escolha uma das opções: ");
    System.out.println("[1] Semanal");
    System.out.println("[2] Mensal");
    select = input.nextInt();
    input.nextLine();
    
    switch (select) {
      case 1:
        newOption = "semanal";

        System.out.println("Indique de quantas em quantas semanas ocorre o pagamento: ");
        select = input.nextInt();
        input.nextLine();

        newOption = newOption + " " + Integer.toString(select);

        System.out.println("\nSegunda[1] Terça[2] Quarta[3] Quinta[4] Sexta[5]");
        System.out.println("Selecione o dia da semana do pagamento: ");
        select = input.nextInt();
        input.nextLine();

        newOption = newOption + " " + weekDays[select-1];
        break;

      case 2:
        newOption = "mensal";
        
        System.out.println("Digite o dia do pagamento: ");
        select = input.nextInt();
        input.nextLine();

        newOption = newOption + " " + Integer.toString(select);
        break;

      default:
        break;
    }

    paymentSchedule.setSchedules(newOption);
  }
}
