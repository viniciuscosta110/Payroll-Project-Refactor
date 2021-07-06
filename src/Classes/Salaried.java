package Classes;

import java.util.LinkedList;

public class Salaried extends Employee 
{
  protected Double month_salary = 0.0;
  protected Double commission = 0.0;
  LinkedList<Sale> sales = new LinkedList<>();
  
  public void setMonth_salary(Double month_salary) 
  {
      this.month_salary = month_salary;
  }

  public Double getMonth_salary() 
  {
      return month_salary;
  }

  public void setCommission(Double commission)
  {
      this.commission = commission;
  }

  public Double getCommission() 
  {
      return commission;
  }

  public void setSales(Sale sale)
  {
    this.sales.add(sale);
  }

  public void getSales() 
  {
    for (Sale sale : sales) 
    {
      System.out.println("\nData: " + sale.getDate() +
      "\nPreço: " + sale.getPrice() + "\n");
    }
  }

  public String printEmployee ()
  {
      return "\nNome: " + this.name +
      "\nEndereço: " + this.address +
      "\nTipo de pagamento: " + this.payment_type +
      "\nID: " + this.uniqueID +
      "\nSalário por mês: " + this.month_salary +
      "\nComissão (em %): " + this.commission;
  }
}
