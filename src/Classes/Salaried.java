package Classes;

public class Salaried extends Employee {
  protected Double month_salary = 0.0;
  protected Double commission = 0.0;
  
  public void setMonth_salary(Double month_salary) {
      this.month_salary = month_salary;
  }

  public Double getMonth_salary() {
      return month_salary;
  }

  public void setCommission(Double commission) {
      this.commission = commission;
  }

  public Double getCommission() {
      return commission;
  }

  public String printEmployee (){
      return "\nNome: " + this.name +
      "\nEndereço: " + this.address +
      "\nTipo de pagamento: " + this.payment_type +
      "\nID: " + this.uniqueID +
      "\nSalário por mês: " + this.month_salary +
      "\nComissão (em %): " + this.commission;
  }
}
