package Functionalities;

import java.util.Scanner;
import java.util.LinkedList;
import Classes.*;

public class ChangeData {
  Scanner input = new Scanner(System.in);

  public void changeEmployee(LinkedList<Employee> employees, LinkedList<Syndicate> syndicates, PaymentSchedule paymentSchedule, int syndicates_counter) {
    int uniqueID;
    Boolean flag = true;
    System.out.println("\nInsira o ID do funcionário\n");
    uniqueID = input.nextInt();
    input.nextLine();

    for (Employee employee : employees) {
      if(employee.getUniqueID() == uniqueID) {
        changeData(employee, employees, syndicates, syndicates_counter, paymentSchedule);
        flag = false;
        break;
      }
    }

    if(flag)
    {
      System.out.println("\nEsse funcionário não existe.\n");
      System.out.println("\nPressione Enter para continuar");
      input.nextLine();
    }
  }

  private void changeData(Employee employee, LinkedList<Employee> employees, LinkedList<Syndicate> syndicates, int syndicates_counter, PaymentSchedule paymentSchedule) {
    int change;
    String text;
    int num;

    System.out.print("\nSelecione o que você quer alterar:\n");
    System.out.println("[1] Alterar nome");
    System.out.println("[2] Alterar endereço");
    System.out.println("[3] Alterar tipo de remuneração");
    System.out.println("[4] Alterar método de pagamento");
    System.out.println("[5] Alterar situação sindical");
    System.out.println("[6] Alterar agenda de pagamento");
    
    change = input.nextInt();
    input.nextLine();

    switch (change) {
      case 1:
        System.out.println("\nNome atual: " + employee.getName());
        System.out.println("Novo nome: ");
        text = input.nextLine();

        employee.setName(text);

        System.out.println("\nNome alterado com sucesso!");
        System.out.println("Pressione enter para continuar!");
        input.nextLine();
        break;
      
      case 2:
        System.out.println("\nEndereço atual: " + employee.getAddress());
        System.out.println("Novo endereço: ");
        text = input.nextLine();
        employee.setAddress(text);

        System.out.println("\nEndereço alterado com sucesso!");
        System.out.println("Pressione enter para continuar!");
        input.nextLine();
        break;

      case 3:
        System.out.println("\nTipo de remuneração atual: " + employee.getPaymentType());
        System.out.println("Selecione um novo tipo de remuneração: ");
        System.out.println("[1] Assalariado");
        System.out.println("[2] Horista");
        num = input.nextInt();
        input.nextLine();

        switch (num) {
          case 1:
            if(employee.getPaymentType().contains("Horista")) {
              Salaried salaried = new Salaried();
              String commissioned;
              Double commission = 0.0;
              String payment_type;

              System.out.print("Salário Mensal: ");
              Double month_salary = input.nextDouble();
              input.nextLine();

              System.out.print("Comissionado (Digite Sim ou Nao): ");
              commissioned = input.nextLine();
          
              if(commissioned.toLowerCase().equals("sim")) {
                System.out.print("Comissão (Digite um número para representar a porcentagem): ");
                commission = input.nextDouble();
                input.nextLine();
          
                payment_type = "Assalariado comissionado";
              }
              else {
                payment_type = "Assalariado";
              }

              salaried.setAddress(employee.getAddress());
              salaried.setName(employee.getName());
              salaried.setPaymentWay(employee.getPaymentWay());
              salaried.setMonthSalary(month_salary);
              salaried.setCommission(commission);
              salaried.setPaymentType(payment_type);
              salaried.setUniqueID(employee.getUniqueID());
              if(employee.getPaymentSchedule() == 1) {
                salaried.setPaymentSchedule(0);
              }
              employees.remove(employee);
              employees.add(salaried);
            }
            else {
              System.out.println("\nEsse funcionário já é assalariado!");
              System.out.println("Pressione Enter para continuar");
              input.nextLine();
            }
            break;

          case 2:
            if(employee.getPaymentType().contains("Assalariado")) {
              Hourly hourly = new Hourly();
              String payment_type = "Horista";

              System.out.print("Salário por hora: ");
              Double hour_salary = input.nextDouble();
              input.nextLine();

              hourly.setAddress(employee.getAddress());
              hourly.setName(employee.getName());
              hourly.setPaymentWay(employee.getPaymentWay());
              hourly.setHour_salary(hour_salary);
              hourly.setPaymentType(payment_type);
              hourly.setUniqueID(employee.getUniqueID());

              employees.remove(employee);
              employees.add(hourly);
            }
            else {
              System.out.println("\nEsse funcionário já é horista!");
              System.out.println("Pressione Enter para continuar");
              input.nextLine();
            }
            break;

          default:
            break;
        }
        break;

      case 4:
        System.out.println("\nMétodo de pagamento atual: " + employee.getPaymentWay());
        System.out.println("\nSelecione um novo método de pagamento: ");
        System.out.println("[1] Correios");
        System.out.println("[2] Em mãos");
        System.out.println("[3] Depósito");
        num = input.nextInt();
        input.nextLine();

        switch (num) {
          case 1:
            employee.setPaymentWay("Correios");
            break;
          case 2:
            employee.setPaymentWay("Em mãos");
            break;

          case 3:
            employee.setPaymentWay("Depósito");
            break;

          default:
            break;
        }
        break;

      case 5:
        Boolean flag = true;
        for (Syndicate syndicate : syndicates) {
          if(syndicate.getEmployeeId() == employee.getUniqueID()) {
            System.out.println("[1] Mudar ID");
            System.out.println("[2] Sair do sindicato");

            num = input.nextInt();
            input.nextLine();
            flag = false;
            
            switch (num) {
              case 1:
                syndicates_counter++;
                syndicate.setSyndicate_id(syndicates_counter);
                System.out.println("ID de sindicato alterado.");
                System.out.println("Pressione Enter para continuar");
                input.nextLine();
                break;

              case 2:
                syndicates.remove(syndicate);
                System.out.println("\nO funcionário "+ employee.getName() +" saiu do sindicato.");
                System.out.println("Pressione Enter para continuar");
                input.nextLine();
                break;
                
              default:
                break;
            }
          }
        }

        if(flag) {
          System.out.println("[1] Entrar no sindicato");
          num = input.nextInt();
          input.nextLine();

          switch (num) {
            case 1:
              isSyndicate(employee.getUniqueID(), false, syndicates_counter, syndicates);
              System.out.println("O funcionário "+ employee.getName() +" entrou do sindicato.");
              System.out.println("Pressione Enter para continuar");
              input.nextLine();
              break;
          
            default:
              break;
          }
        }
        break;

      case 6:
        System.out.println("\nLegenda:\n$ = último dia útil\n");
        System.out.println("Selecione uma nova agenda: ");
        String[] weekDays = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY","FRIDAY"};
        String[] portugueseWeekDays = {"Segunda", "Terça", "Quarta", "Quinta","Sexta"};
        int j = 1;

        for (String schedule : paymentSchedule.getSchedules()) {
          
          if(schedule.contains("semanal")) {
            int i = 0;
            String printAux = schedule;

            for (String string : weekDays) {
              if(schedule.contains(string)) {
                printAux = printAux.replace(string, portugueseWeekDays[i]);
                break;
              }

              i = i + 1;
            }

            System.out.println("[" + j + "] " + printAux);
          }
          else {
            System.out.println("[" + j + "] " + schedule);
          }

          j = j + 1;
        }

        int paymentScheduleNumber = input.nextInt();
        input.nextLine();

        employee.setPaymentSchedule(paymentScheduleNumber-1);

        System.out.println("\nAgenda alterada com sucesso.");
        System.out.println("Pressione Enter para continuar");
        input.nextLine();
        break;

      default:
        break;
    }
  }

  public void isSyndicate(int uniqueID, Boolean flag, int syndicates_counter, LinkedList<Syndicate> syndicates) {
    Syndicate syndicate = new Syndicate();
    String inSyndicate;
    Double syndicate_fee = 0.0;

    if(flag) {
      System.out.print("\nEstá no sindicato (Digite Sim ou Nao): ");
      inSyndicate = input.nextLine();
    }
    else {
      inSyndicate = "sim";
    }
    

    if(inSyndicate.toLowerCase().equals("sim"))
    {
      int syndicate_id = syndicates_counter + 1;

      syndicates_counter++;

      System.out.print("Taxa sindical: ");
      syndicate_fee = input.nextDouble();
      input.nextLine();

      syndicate.setSyndicate_id(syndicate_id);
      syndicate.setSyndicate_fee(syndicate_fee);
      syndicate.setEmployeeId(uniqueID);

      syndicates.add(syndicate);
    }

    if(!flag)
    {
      System.out.println("\nBem-vindo ao sindicato!\n");
      System.out.println("\nPressione Enter para continuar");
      input.nextLine();
    }
  }
}
