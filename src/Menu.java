import static Classes.Payroll.*;
import static Functionalities.HelpFunctions.*;
import static Functionalities.ListEmployees.*;

import java.util.*;
import Classes.*;
import Classes.History.*;
import Functionalities.*;
import Functionalities.AddEmployees.*;

public class Menu {

  HistoryHandlerInterface historyHandler = new NullHistoryHandler();
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
            listAllEmployees(employees);
            input.nextLine();
            clear();
            stateFlag = false;
            break;

          case 4:
            TimeCardFunctions ticf = new TimeCardFunctions();
            ticf.addTimeCard(employees);
            clear();
            break;

          case 5:
            SaleFunctions saf = new SaleFunctions();
            saf.addSale(employees);
            clear();
            break;

          case 6:
            AddFee af = new AddFee();
            af.newFee(employees, syndicates);
            clear();
            break;

          case 7:
            ChangeData changeD = new ChangeData();
            changeD.changeEmployee(employees, syndicates, paymentSchedule, syndicates_counter);;
            clear();
            break;

          case 8:
            verifyPayment(employees, syndicates, paymentSchedule);
            input.nextLine();
            clear();
            break;
          
          case 9:
            ScheduleFunctions scf = new ScheduleFunctions();
            scf.newSchedule(paymentSchedule);
            clear();
            break;

          case 10:
            undoHandler();
            input.nextLine();
            clear();
            stateFlag = false;
            break;

          case 11:
            redoHandler();
            input.nextLine();
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

  
  private void redoHandler() {
    clear();

    if(history.getHead() > history.getStates().size() - 1) {
      int head = history.getHead();

      historyHandler = new HistoryHandler(head, history.getStates());
      history.setHead(head+1);
    }

    States previusState = historyHandler.redo();

    employees = previusState.getEmployees();
    syndicates = previusState.getSyndicates();
    paymentSchedule = previusState.getPaymentSchedule();
    employees_counter = previusState.getEmployees_counter();
    syndicates_counter = previusState.getSyndicates_counter();
  }

  private void undoHandler() {
    clear();

    if(history.getHead() > 0) {
      int head = history.getHead();
      
      historyHandler = new HistoryHandler(head, history.getStates());
      history.setHead(head-1);
    }

    States nextState = historyHandler.undo();

    employees = nextState.getEmployees();
    syndicates = nextState.getSyndicates();
    paymentSchedule = nextState.getPaymentSchedule();
    employees_counter = nextState.getEmployees_counter();
    syndicates_counter = nextState.getSyndicates_counter();
  }
}
