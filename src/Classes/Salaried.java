package Classes;

public class Salaried extends Employee 
{
  protected Double monthSalary = 0.0;
  protected Double commission = 0.0;
  
  public void setMonthSalary(Double monthSalary) 
  {
    this.monthSalary = monthSalary;
  }

  public Double getMonthSalary() 
  {
    return monthSalary;
  }

  public void setCommission(Double commission)
  {
    this.commission = commission;
  }

  public Double getCommission() 
  {
    return commission;
  }

  public Salaried() {
    
  }

  public Salaried(String name, String address, int uniqueID, int paymentSchedule, String paymentType, String paymentWay, Double monthSalary, Double commission) {
    super(name, address, uniqueID, paymentSchedule, paymentType, paymentWay);
    this.monthSalary = monthSalary;
    this.commission = commission;
  }

  public String printEmployee ()
  {
    return "\nNome: " + this.name +
    "\nEndereço: " + this.address +
    "\nTipo de pagamento: " + this.paymentType +
    "\nVia de pagamento: " + this.paymentWay +
    "\nSalário por mês: " + this.monthSalary +
    "\nComissão (em %): " + this.commission + "\n" +
    "\nID: " + this.uniqueID;
  }
}
