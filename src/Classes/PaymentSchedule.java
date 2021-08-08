package Classes;

import java.time.*;
import java.util.*;

public class PaymentSchedule {
  ArrayList<String> schedules = new ArrayList<>();

  public Boolean checkMonthlyPayment() {
    LocalDate today = LocalDate.now();
    Boolean flag = false;

    if(today.getDayOfMonth() == today.lengthOfMonth() - 2) {
      if(today.getDayOfWeek() == DayOfWeek.FRIDAY) {
        flag = true;
      }
    }

    if(today.getDayOfMonth() == today.lengthOfMonth())
    {
      if(!(today.getDayOfWeek().equals(DayOfWeek.SATURDAY)) && !(today.getDayOfWeek().equals(DayOfWeek.SUNDAY)))
      {
        flag = true;
      }
    }

    return flag;
  }

  public void newSchedule() {
    String newOption = "";
    String[] weekDays = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY","FRIDAY"};
    Scanner input = new Scanner(System.in);
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

    this.schedules.add(newOption);

    input.close();
  }

  public PaymentSchedule() {
    String Default = "mensal $";
    this.schedules.add(Default);
    
    Default = "semanal 1 FRIDAY";
    this.schedules.add(Default);
    
    Default = "semanal 2 FRIDAY";
    this.schedules.add(Default);
  }
}