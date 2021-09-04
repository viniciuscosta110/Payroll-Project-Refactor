import static Classes.Payroll.*;
import static Functionalities.HelpFunctions.*;

import java.util.*;
import Classes.*;
import Functionalities.*;

public class Menu {

  Scanner input = new Scanner(System.in);
  int employees_counter = 0;
  int syndicates_counter = -1;
  PaymentSchedule paymentSchedule = new PaymentSchedule();
  LinkedList<Employee> employees = new LinkedList<>();
  LinkedList<Syndicate> syndicates = new LinkedList<>();
  States newState;
  History history = new History();
  Boolean stateFlag = true;

  public void init() {
    Scanner input = new Scanner(System.in);

    System.out.println("--------------------------------------------");
    System.out.println("Bem Vindo ao sistema de Gerencimento da Loja");

    while(true) {
      System.out.println("Selecione uma opção para acessá-la.\n");

      System.out.println("[1] Adicionar Funcionário");
      System.out.println("[2] Remover Funcionário");
      System.out.println("[3] Listar Funcionários");
      System.out.println("[4] Lançamento de ponto");
      System.out.println("[5] Lançamento de vendas");
      System.out.println("[6] Lançar taxa de serviço");
      System.out.println("[7] Alterar dados do funcionário");
      System.out.println("[8] Rodar folha de pagamento de hoje");
      System.out.println("[9] Criar novo perfil de pagamento");
      System.out.println("[10] Desfazer a última alteração");
      System.out.println("[11] Refazer");
      System.out.println("[12] Sair");
      
      String key_handler = input.nextLine();
      clear();

      int key = 0;

      if(Integer.parseInt(key_handler) >= 0 && Integer.parseInt(key_handler) <= 12) {
        key = Integer.parseInt(key_handler);

        switch (key) {
          case 1:
            AddEmployee add = new AddEmployee();
            add.newEmployee(syndicates, employees, syndicates_counter, employees_counter);

            employees_counter = add.getEmployees_counter();
            syndicates_counter = add.getSyndicates_counter();

            clear();
            break;

          case 2:
            RemoveEmployee rm = new RemoveEmployee();
            rm.deleteEmployee(employees);
            clear();
            break;

          case 3:
            ListEmployees le = new ListEmployees();
            le.listAllEmployees(employees);
            clear();
            stateFlag = false;
            break;

          case 4:
            addTimeCard();
            clear();
            break;

          case 5:
            addSale();
            clear();
            break;

          case 6:
            addFee();
            clear();
            break;

          case 7:
            ChangeData changeD = new ChangeData();
            changeD.changeEmployee(employees, syndicates, paymentSchedule, syndicates_counter);;
            clear();
            break;

          case 8:
            rollPayment();
            clear();
            break;
          
          case 9:
            createNewSchedule();
            clear();
            break;

          case 10:
            undoHandler();
            clear();
            stateFlag = false;
            break;

          case 11:
            redoHandler();
            clear();
            stateFlag = false;
            break;
          
          case 12:
            input.close();
            System.exit(0);
            break;

          default:
            stateFlag = false;
            break;
        }

        if(stateFlag) {
          newState = new States(paymentSchedule, employees, syndicates, employees_counter, syndicates_counter);
          history.setStates(newState);
          stateFlag = true;
        }
      }
      else {
        System.out.println("Digite uma opção válida.\n");
      }
    }
  }

  private void createNewSchedule() {
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

  private void addTimeCard() {
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

  private void addSale() {
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
        if(employee2.getPaymentType() == "Assalariado" || employee2.getPaymentType() == "Assalariado comissionado") {
          flag = false;
          salaried = false;
          employee = (Salaried) employee2;
        }
      }
    }

    if(flag) {
      if(salaried) {
        System.out.println("\nEsse funcionário não é Assalariado!\n");
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

  private void addFee() {
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

        for (Syndicate syndicate3 : syndicates) {
          System.out.println(syndicate3.printSyndicate());
        }

        System.out.println("\nTaxa cadastrada com sucesso!\n");
        System.out.println("\nPressione Enter para continuar");
        input.nextLine();
        break;
      }
    }
  }

  private void rollPayment() {
    verifyPayment(employees, syndicates, paymentSchedule);

    System.out.println("Pagamentos Efetuados");
    System.out.println("Pressione Enter para continuar");
    input.nextLine();
  }

  
  private void redoHandler() {
    clear();

    States previusState = history.redo();

    if(previusState != null) {
      employees = previusState.getEmployees();
      syndicates = previusState.getSyndicates();
      paymentSchedule = previusState.getPaymentSchedule();
      employees_counter = previusState.getEmployees_counter();
      syndicates_counter = previusState.getSyndicates_counter();
    }
  }

  private void undoHandler() {
    clear();

    States nextState = history.undo();
    
    if(nextState != null) {
      employees = nextState.getEmployees();
      syndicates = nextState.getSyndicates();
      paymentSchedule = nextState.getPaymentSchedule();
      employees_counter = nextState.getEmployees_counter();
      syndicates_counter = nextState.getSyndicates_counter();
    }
  }
}
