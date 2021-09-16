# Refatoração do Sistema de Folha de Pagamento

## Code Smells encontrados:

- *Duplicate code*
    - Citarei a localização de algumas das duplicações no código antigo
        - Main 232-261 / 316-345 (Movido para AddEmployee - inCommon)
        - Hourly 40-45 / Salaried 28-33 (Foi movido para Employee)

- *Ifs usados sem necessidade*
    - Uso excessivo de ifs/switches
    - Alguns ifs foram tirados, porém não todos. Foi implementado um tipo de Command em AddEmployees, utilizando hierarquia e polimorfismo

- *Introduce Null Object*
    - Na pasta History, foi implementando um Introduce Null Object e utilizado na Main

- *Generative Speculation*
    - Construtures e métodos não utilizados serão descartados
    - Foi feito uma classe EmployeeCreator para facilitar a criação de um funcionário
    
- *Outros*
    - Serão feitos construtores apropriados, para evitar o uso excessivo de funções nas classes
