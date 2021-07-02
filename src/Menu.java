import java.util.*;
import Classes.*;

public class Menu {

  Scanner input = new Scanner(System.in);
  int employees_counter = 0;
  LinkedList<Employee> employees = new LinkedList<>();

  public void init()
  {
    Scanner input = new Scanner(System.in);

    System.out.println("--------------------------------------------");
    System.out.println("Bem Vindo ao sistema de Gerencimento da Loja");

    while(true)
    {
      System.out.println("Selecione uma opção para acessá-la.\n");

      System.out.println("[1] Adicionar Funcionário");
      System.out.println("[2] Remover Funcionário");
      System.out.println("[3] Listar Funcionários");
      System.out.println("[4] Sair");
      
      String key_handler = input.nextLine();
      clear();

      int key = 0;

      if(key_handler.charAt(0) >= '0' && key_handler.charAt(0) <= '4')
      {
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
            input.close();
            System.exit(0);
            break;

          default:
            break;
        }
      }
      else
      {
        System.out.println("Digite uma opção válida.\n");
      }
    }
  }

  private void clear()
  {
    for (int i = 0; i < 20; i++) {
        System.out.println('\n');
    }
  }

  private void addEmployee()
  {
    while(true)
    {
      System.out.println("Selecione uma opção para acessá-la.\n");
      System.out.println("[1] Funcionário Horista");
      System.out.println("[2] Funcionário Assalariado");
      System.out.println("[3] Voltar");

      String key_handler = input.nextLine();
      clear();

      int key = 0;

      if(key_handler.charAt(0) >= '0' && key_handler.charAt(0) <= '4')
      {
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
      else
      {
        System.out.println("Digite uma opção válida.\n");
      }
    }
  }

  private void addHourly()
  {
    Hourly employee = new Hourly();
    
    String name;
    String address;
    String payment_type = "Horista";
    Double hour_salary = 0.0;

    int uniqueID = employees_counter + 1;
    employees_counter++;

    System.out.println("Insira os dados do funcionário\n\n");
    
    System.out.print("Nome: ");
    name = input.nextLine();

    System.out.print("Endereço: ");
    address = input.nextLine();

    System.out.print("Salário por hora: ");
    hour_salary = input.nextDouble();
    input.nextLine();

    employee.setName(name);
    employee.setAddress(address);
    employee.setHour_salary(hour_salary);
    employee.setPayment_type(payment_type);
    employee.setUniqueID(uniqueID);

    employees.add(employee);

    System.out.println("\nFuncionário cadastrado!\n");
    System.out.println("\nPressione Enter para continuar");
    input.nextLine();
  }

  private void addSalaried()
  {
    Salaried employee = new Salaried();
    
    String name;
    String address;
    String payment_type = "";
    String commissioned;
    Double commission = 0.0;
    Double month_salary = 0.0;

    int uniqueID = employees_counter + 1;

    employees_counter++;

    System.out.println("Insira os dados do funcionário\n\n");
    
    System.out.print("Nome: ");
    name = input.nextLine();

    System.out.print("Endereço: ");
    address = input.nextLine();

    System.out.print("Salário Mensal: ");
    month_salary = input.nextDouble();
    input.nextLine();

    System.out.print("Comissionado (Digite Sim ou Não): ");
    commissioned = input.nextLine();

    if(commissioned.toLowerCase().equals("sim"))
    {
      System.out.print("Comissão (Digite um número para representar a porcentagem): ");
      commission = input.nextDouble();
      input.nextLine();

      payment_type = "Assalariado comissionado";
    }
    else
    {
      payment_type = "Assalariado";
    }
    
    employee.setAddress(address);
    employee.setName(name);
    employee.setMonth_salary(month_salary);
    employee.setUniqueID(uniqueID);
    employee.setCommission(commission);
    employee.setPayment_type(payment_type);

    employees.add(employee);

    System.out.println("\nFuncionário cadastrado!\n");
    System.out.println("\nPressione Enter para continuar");
    input.nextLine();
  }

  private void listEmployees()
  {
    System.out.println("Lista de Funcionários\n");
    if(employees.size() > 0)
    {
      for (Employee employee : employees) {
        if(employee.getPayment_type() == "Assalariado" || employee.getPayment_type() == "Assalariado comissionado")
        {
          Salaried aux = (Salaried) employee;
          System.out.println(aux.printEmployee());
        }
        else if(employee.getPayment_type() == "Horista")
        {
          Hourly aux = (Hourly) employee;
          System.out.println(aux.printEmployee());
        }
      }
      
      System.out.println("\nPressione Enter para continuar");
      input.nextLine();
    }
    else
    {
      System.out.println("\nLista Vazia\n");
      System.out.println("\nPressione Enter para continuar");
      input.nextLine();
    }
  }

  private void removeEmployee()
  {
    int id;
    boolean flag = true;

    System.out.println("Digite o ID do funcionário que deseja remover.");
    System.out.print("ID: ");

    id = input.nextInt();
    input.nextLine();

    for (Employee employee : employees) 
    {
      if(employee.getUniqueID() == id)
      {
        flag = false;
        employees.remove(employee);

        System.out.println("\nFuncionário removido.\n");
        System.out.println("\nPressione Enter para continuar.\n");
        input.nextLine();
        
        clear();
        break;
      }
    }

    if(flag)
    {
      System.out.println("\nEsse funcionário não está cadastrado!\n");
      System.out.println("\nPressione Enter para continuar");
      input.nextLine();
    }
  }
}
