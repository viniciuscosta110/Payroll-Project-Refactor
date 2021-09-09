# Refatoração do Sistema de Folha de Pagamento

## Code Smells encontrados:

- *Duplicate code*
    - Citarei a localização de algumas das duplicações no código antigo
        - Main 232-261 / 316-345 (Movido para AddEmployee - inCommon)
        - Hourly 40-45 / Salaried 28-33 (Foi movido para Employee)

- *Long Term*
- *Ifs usados sem necessidade*
    - Uso excessivo de ifs/switches
    - Alguns ifs foram tirados, porém não todos. Foi implementado um tipo de Command em AddEmployees, utilizando hierarquia e polimorfismo
- *Generative Speculation*
    - Construtures e métodos não utilizados serão descartados
- *Outros*
    - Serão feitos construtores apropriados, para evitar o uso excessivo de funções nas classes
