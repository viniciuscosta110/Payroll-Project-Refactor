# Refatoração do Sistema de Folha de Pagamento

## Code Smells encontrados:

- *Duplicate code*
    - Citarei a localização de algumas das duplicações no código antigo
        - Main 232-261 / 316-345 (Movido para AddEmployee - inCommon)
        - Hourly 40-45 / Salaried 28-33 (Foi movido para Employee)

- *Ifs usados sem necessidade*
    - Uso excessivo de ifs/switches
    - Alguns ifs foram tirados, porém não todos. Foi implementado um tipo de Command em src/Funcionalities/AddEmployees, utilizando hierarquia e polimorfismo

#### Antes
``` java
  private void addEmployee() {
    while(true) {
      System.out.println("Selecione uma opção para acessá-la.\n");
      System.out.println("[1] Funcionário Horista");
      System.out.println("[2] Funcionário Assalariado");

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
```

#### Depois
``` java
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
```

- *Introduce Null Object*
    - Na pasta History, foi implementando um Introduce Null Object, usando polimorfismo e hierarquia, sendo utilizado no Menu

#### Antes
``` java
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
```

#### Depois
``` java
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
```

- *Generative Speculation*
    - Construtures e métodos não utilizados serão descartados
    - Foi feito uma classe EmployeeCreator para facilitar a criação de um funcionário
    
- *Outros*
    - Serão feitos construtores apropriados, para evitar o uso excessivo de funções nas classes
