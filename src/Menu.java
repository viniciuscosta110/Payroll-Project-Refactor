import java.util.*;

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
      System.out.println("Selecione uma opção para acessá-la.");

      System.out.println("[1] Adicionar Funcionário");
      System.out.println("[2] Remover Funcionário");
      System.out.println("[3] Listar Funcionários");
      System.out.println("[4] Sair");
      
      int key_handler = input.nextInt();
      input.nextLine();
      
      switch (key_handler) {
          case 1:
            addEmployee();
            clear();
            break;

          case 2:
            removeEmployee();
            break;
          case 3:
            listEmployees();
            break;

          case 4:
            System.exit(0);
            break;

          default:
            listEmployees();
            break;
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
    Employee employee = new Employee();

    String name;
    String address;
    int commissioned;
    int uniqueID = employees_counter + 1;
    employees_counter++;
    
    System.out.print("Nome: ");
    name = input.nextLine();

    System.out.print("Address: ");
    address = input.nextLine();
    
    System.out.print("Commissioned: ");
    commissioned = input.nextInt();
    input.nextLine();

    employee.setAddress(address);
    employee.setName(name);
    employee.setCommissioned(commissioned);
    employee.setUniqueID(uniqueID);

    employees.add(employee);
  }

  private void listEmployees()
  {
    if(employees.size() > 0)
    {
      for (Employee employee : employees) {
        System.out.println(employee.printEmployee());
      }
    }
    else
    {
      System.out.println("\nLista Vazia\n");
    }
  }

  private void removeEmployee()
  {
    int id;
    int size = employees.size();
    Employee aux = new Employee();

    System.out.println("Digite o ID do funcionário que deseja remover.");
    System.out.print("ID: ");
    id = input.nextInt();
    input.nextLine();

    if(id <= size)
    {
      aux = employees.get(id-1);

      if(employees.contains(aux))
      {
        employees.remove(id-1);
      }
    }
    else
    {
      System.out.println("\nEsse funcionário não está cadastrado!\n");
    }
  }
}
