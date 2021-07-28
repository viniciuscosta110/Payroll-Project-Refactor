import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
import Classes.*;
import Classes.People.Employee;
import Classes.People.Hourly;
import Classes.People.Salaried;
import Classes.People.Syndicate;

public class Menu {

  Scanner input = new Scanner(System.in);
  int employees_counter = 0;
  int syndicates_counter = -1;
  ArrayList<PaymentSchedule> paymentSchedule = new ArrayList<>();
  LinkedList<Employee> employees = new LinkedList<>();
  LinkedList<Syndicate> syndicates = new LinkedList<>();

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
      System.out.println("[9] Sair");
      
      String key_handler = input.nextLine();
      clear();

      int key = 0;

      if(key_handler.charAt(0) >= '0' && key_handler.charAt(0) <= '9') {
        key = key_handler.charAt(0) - '0';

        switch (key) {
          case 1:
            addEmployee();
            clear();
            break;

          case 2:
            removeEmployee();
            clear();
            break;

          case 3:
            listEmployees();
            clear();
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
            changeEmployee();
            clear();
            break;

          case 8:
            rollPayment();
            break;

          case 9:
            input.close();
            System.exit(0);
            break;

          default:
            break;
        }
      }
      else {
        System.out.println("Digite uma opção válida.\n");
      }
    }
  }

  private void clear() {
    for (int i = 0; i < 20; i++) {
        System.out.println('\n');
    }
  }

  private void addEmployee()
  {
    while(true) {
      System.out.println("Selecione uma opção para acessá-la.\n");
      System.out.println("[1] Funcionário Horista");
      System.out.println("[2] Funcionário Assalariado");
      System.out.println("[3] Voltar");

      String key_handler = input.nextLine();
      clear();

      int key = 0;

      if(key_handler.charAt(0) >= '0' && key_handler.charAt(0) <= '3') {
        key = key_handler.charAt(0) - '0';

        switch (key) {
          case 1:
            addHourly();
            clear();
            break;

          case 2:
            addSalaried();
            clear();
            break;

          case 3:
            clear();
            return;

          default:
            break;
        }

        break;
      }
      else {
        System.out.println("Digite uma opção válida.\n");
      }
    }
  }

  private void addHourly() {
    Hourly employee = new Hourly();
    
    String name;
    String address;
    String payment_type = "Horista";
    int payment_way;
    String hour_salary = "";

    int uniqueID = employees_counter + 1;
    employees_counter++;

    System.out.println("Insira os dados do funcionário\n\n");
    
    System.out.print("Nome: ");
    name = input.nextLine();

    System.out.print("Endereço: ");
    address = input.nextLine();

    System.out.println("Método de pagamento: ");
    System.out.println("[1] Correios");
    System.out.println("[2] Em mãos");
    System.out.println("[3] Depósito");
    payment_way = input.nextInt();
    input.nextLine();

    switch (payment_way) {
      case 1:
        employee.setPayment_way("Correios");
        break;
      case 2:
        employee.setPayment_way("Em mãos");
        break;

      case 3:
        employee.setPayment_way("Depósito");
        break;

      default:
        break;
    }

    while(true) {
      System.out.print("\nSalário por hora: ");
      hour_salary = input.nextLine();

      Boolean flag = true;
      int len = hour_salary.length();

      for (int i = 0; i < len; i++) {
        if(!(hour_salary.charAt(i) >= '0' && hour_salary.charAt(i) <= '9') || (hour_salary.charAt(i) <= '.') || (hour_salary.charAt(i) <= ',')) {
          flag = false;
          clear();
          System.out.println("Digite um número.\n");

          break;
        }
      }

      if(flag) {
        break;
      }
    }

    isSyndicate(uniqueID, true);

    employee.setName(name);
    employee.setAddress(address);
    employee.setHour_salary(Double.parseDouble(hour_salary));
    employee.setPayment_type(payment_type);
    employee.setUniqueID(uniqueID);

    employees.add(employee);

    System.out.println("\nFuncionário cadastrado!\n");
    System.out.println("\nPressione Enter para continuar");
    input.nextLine();
  }

  private void addSalaried() {
    Salaried employee = new Salaried();
    
    String name;
    String address;
    String payment_type = "";
    int payment_way;
    String commissioned;
    String month_salary;
    Double commission = 0.0;

    int uniqueID = employees_counter + 1;

    employees_counter++;

    System.out.println("Insira os dados do funcionário\n\n");
    
    System.out.print("Nome: ");
    name = input.nextLine();

    System.out.print("Endereço: ");
    address = input.nextLine();

    System.out.println("Método de pagamento: ");
    System.out.println("[1] Correios");
    System.out.println("[2] Em mãos");
    System.out.println("[3] Depósito");
    payment_way = input.nextInt();
    input.nextLine();

    switch (payment_way) {
      case 1:
        employee.setPayment_way("Correios");
        break;
      case 2:
        employee.setPayment_way("Em mãos");
        break;

      case 3:
        employee.setPayment_way("Depósito");
        break;

      default:
        break;
    }

    while(true) {
      System.out.print("Salário Mensal: ");
      month_salary = input.nextLine();

      Boolean flag = true;
      int len = month_salary.length();

      for (int i = 0; i < len; i++) {
        if(!(month_salary.charAt(i) >= '0' && month_salary.charAt(i) <= '9')) {
          flag = false;
          clear();
          System.out.println("Digite um número.\n");

          break;
        }
      }

      if(flag) {
        break;
      }
    }

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

    isSyndicate(uniqueID, true);
    
    employee.setAddress(address);
    employee.setName(name);
    employee.setMonth_salary(Double.parseDouble(month_salary));
    employee.setUniqueID(uniqueID);
    employee.setCommission(commission);
    employee.setPayment_type(payment_type);

    employees.add(employee);

    System.out.println("\nFuncionário cadastrado!\n");
    System.out.println("\nPressione Enter para continuar");
    input.nextLine();
  }

  private void removeEmployee() {
    int id;
    boolean flag = true;

    System.out.println("Digite o ID do funcionário que deseja remover.");
    System.out.print("ID: ");

    id = input.nextInt();
    input.nextLine();

    for (Employee employee : employees) {
      if(employee.getUniqueID() == id) {
        flag = false;
        employees.remove(employee);

        System.out.println("\nFuncionário removido.\n");
        System.out.println("\nPressione Enter para continuar.\n");
        input.nextLine();
        
        clear();
        break;
      }
    }

    if(flag) {
      System.out.println("\nEsse funcionário não está cadastrado!\n");
      System.out.println("\nPressione Enter para continuar");
      input.nextLine();
    }
  }

  private void listEmployees() {
    System.out.println("Lista de Funcionários\n");

    if(employees.size() > 0) {
      for (Employee employee : employees) {
        if(employee.getPayment_type() == "Assalariado" || employee.getPayment_type() == "Assalariado comissionado") {
          Salaried aux = (Salaried) employee;
          System.out.println(aux.printEmployee());
        }
        else if(employee.getPayment_type() == "Horista") {
          Hourly aux = (Hourly) employee;
          System.out.println(aux.printEmployee());
        }
      }
      
      System.out.println("\nPressione Enter para continuar");
      input.nextLine();
    }
    else {
      System.out.println("\nLista Vazia\n");
      System.out.println("\nPressione Enter para continuar");
      input.nextLine();
    }
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
        if(employee2.getPayment_type() == "Horista") {
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
        if(employee2.getPayment_type() == "Assalariado" || employee2.getPayment_type() == "Assalariado comissionado") {
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

  private void isSyndicate(int uniqueID, Boolean flag) {
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

  private void changeEmployee() {
    int uniqueID;
    Boolean flag = true;
    System.out.println("\nInsira o ID do funcionário\n");
    uniqueID = input.nextInt();
    input.nextLine();

    for (Employee employee : employees) {
      if(employee.getUniqueID() == uniqueID) {
        changeData(employee);
        flag = false;
      }
    }

    if(flag)
    {
      System.out.println("\nEsse funcionário não existe.\n");
      System.out.println("\nPressione Enter para continuar");
      input.nextLine();
    }
  }

  private void changeData(Employee employee) {
    int change;
    String text;
    int num;

    System.out.print("\nSelecione o que você quer alterar:\n");
    System.out.println("[1] Alterar nome");
    System.out.println("[2] Alterar endereço");
    System.out.println("[3] Alterar tipo de remuneração");
    System.out.println("[4] Alterar método de pagamento");
    System.out.println("[5] Alterar situação sindical");
    System.out.println("[6] Voltar");
    
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
        break;

      case 3:
        System.out.println("\nTipo de remuneração atual: " + employee.getPayment_type());
        System.out.println("Selecione um novo tipo de remuneração: ");
        System.out.println("[1] Assalariado");
        System.out.println("[2] Horista");
        num = input.nextInt();
        input.nextLine();

        switch (num) {
          case 1:
            if(employee.getPayment_type() == "Horista") {
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
              salaried.setPayment_way(employee.getPayment_way());
              salaried.setMonth_salary(month_salary);
              salaried.setCommission(commission);
              salaried.setPayment_type(payment_type);

              employees.remove(employee);
              employees.add(salaried);
            }
            else {
              System.out.println("Esse funcionário já é horista!");
              System.out.println("Pressione Enter para continuar");
              input.nextLine();
            }
            break;

          case 2:
            if(employee.getPayment_type() != "Horista") {
              Hourly hourly = new Hourly();
              String payment_type = "Horista";

              System.out.print("Salário por hora: ");
              Double hour_salary = input.nextDouble();
              input.nextLine();

              hourly.setAddress(employee.getAddress());
              hourly.setName(employee.getName());
              hourly.setPayment_way(employee.getPayment_way());
              hourly.setHour_salary(hour_salary);
              hourly.setPayment_type(payment_type);

              employees.remove(employee);
              employees.add(hourly);
            }
            else {
              System.out.println("Esse funcionário já é assalariado!");
              System.out.println("Pressione Enter para continuar");
              input.nextLine();
            }
            break;

          default:
            break;
        }
        break;

      case 4:
        System.out.println("\nMétodo de pagamento atual: " + employee.getPayment_way());
        System.out.println("\nSelecione um novo método de pagamento: ");
        System.out.println("[1] Correios");
        System.out.println("[2] Em mãos");
        System.out.println("[3] Depósito");
        num = input.nextInt();
        input.nextLine();

        switch (num) {
          case 1:
            employee.setPayment_way("Correios");
            break;
          case 2:
            employee.setPayment_way("Em mãos");
            break;

          case 3:
            employee.setPayment_way("Depósito");
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
            System.out.println("[3] Voltar");

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
                System.out.println("O funcionário "+ employee.getName() +" saiu do sindicato.");
                System.out.println("Pressione Enter para continuar");
                input.nextLine();
                break;
              case 3:
                break;
                
              default:
                break;
            }
          }
        }

        if(flag) {
          System.out.println("[1] Entrar no sindicato");
          System.out.println("[2] Voltar");
          num = input.nextInt();
          input.nextLine();

          switch (num) {
            case 1:
              isSyndicate(employee.getUniqueID(), false);
              break;

            case 2:
              break;
          
            default:
              break;
          }
        }
      break;

      case 6:
        break;

      default:
        break;
    }
  }

  private void rollPayment() {
    LocalDate today = LocalDate.now();

    System.out.println("Hoje é " + today + "\n");
    
    if(today.getDayOfWeek() == DayOfWeek.TUESDAY) {
      for (Employee employee : employees) {
        Hourly hourly = (Hourly)employee;
        hourly.printSalary();
        for(Syndicate syndicate:syndicates)
        {
          if(syndicate.getEmployeeId() == employee.getUniqueID())
          {
            Double fee = syndicate.getSyndicate_fee();
            System.out.println("Salário da semana: "+ ((hourly.getTimeCards().getLast().getWorked_week_time() * hourly.getHour_salary()) - fee) + "\n");
          }
        }
      }
    }

    System.out.println("Pagamentos Efetuados");
    System.out.println("Pressione Enter para continuar");
    input.nextLine();
  }
}
