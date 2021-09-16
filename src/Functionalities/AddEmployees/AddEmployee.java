package Functionalities.AddEmployees;

import static Functionalities.HelpFunctions.*;

import java.util.LinkedList;
import java.util.Scanner;
import Classes.*;

public class AddEmployee{
  Scanner input = new Scanner(System.in);
  int employees_counter = 0;
  int syndicates_counter = -1;
  LinkedList<Syndicate> syndicates = new LinkedList<>();

  public int getEmployees_counter() {
    return employees_counter;
  }

  public int getSyndicates_counter() {
    return syndicates_counter;
  }

  public LinkedList<Syndicate> getSyndicates() {
    return this.syndicates;
  }

  public void newEmployee(LinkedList<Syndicate> syndicates, LinkedList<Employee> employees, int syndicates_counter, int employees_counter) {
    this.employees_counter = employees_counter + 1;
    this.syndicates_counter = syndicates_counter + 1;
    this.syndicates = syndicates;

    AddSalaried AddS = new AddSalaried(syndicates, this.employees_counter, this.syndicates_counter);
    AddHourly AddH = new AddHourly(syndicates, this.employees_counter, this.syndicates_counter);
    AddController slot = new AddController();

    while(true) {
      System.out.println("Selecione uma opção para acessá-la.\n");
      System.out.println("[1] Funcionário Horista");
      System.out.println("[2] Funcionário Assalariado");

      String key_handler = input.nextLine();
      clear();

      int key = 0;

      if(key_handler.charAt(0) >= '1' && key_handler.charAt(0) <= '2') {
        key = key_handler.charAt(0) - '0';

        switch (key) {
          case 1:
            slot.setSlot(AddH);
            break;

          case 2:
            slot.setSlot(AddS);
            break;

          default:
            break;
        }

        break;
      }
      else {
        System.out.println("Digite uma opção válida.\n");
      }
    }

    employees.add(slot.execute());

    System.out.println("\nFuncionário cadastrado!\n");
    System.out.println("\nPressione Enter para continuar");
    input.nextLine();
  }

  protected void inCommon(Employee employee, LinkedList<Syndicate> syndicates, int employees_counter, int syndicates_counter) {
    String name;
    String address = "";

    System.out.println("Insira os dados do funcionário\n\n");
    
    System.out.print("Nome: ");
    name = input.nextLine();

    System.out.print("Endereço: ");
    address = input.nextLine();

    System.out.println("Método de pagamento: ");
    System.out.println("[1] Correios");
    System.out.println("[2] Em mãos");
    System.out.println("[3] Depósito");
    int payment_way = input.nextInt();
    input.nextLine();

    switch (payment_way) {
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

    isSyndicate(employees_counter, true, syndicates, syndicates_counter);

    employee.setAddress(address);
    employee.setName(name);
    employee.setUniqueID(employees_counter);
  }

  public void isSyndicate(int uniqueID, Boolean flag, LinkedList<Syndicate> syndicates, int syndicates_counter) {
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
      int syndicate_id = syndicates_counter;

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
