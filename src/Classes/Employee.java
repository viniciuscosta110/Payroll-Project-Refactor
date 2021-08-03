package Classes;

import java.util.ArrayList;

public class Employee {
  protected String name;
  protected String address;
  protected int uniqueID;
  protected String paymentType;
  protected String paymentWay;
  protected ArrayList<Sale> sales = new ArrayList<>();

  public void setAddress(String address) {
    this.address = address;
  }

  public String getAddress() {
    return address;
  }

  public void setName(String name)  {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setUniqueID(int uniqueID)  {
    this.uniqueID = uniqueID;
  }

  public int getUniqueID()  {
    return uniqueID;
  }

  public void setPaymentType(String paymentType)  {
    this.paymentType = paymentType;
  }

  public String getPaymentType() {
      return paymentType;
  }

  public void setPaymentWay(String paymentWay)  {
    this.paymentWay = paymentWay;
  }

  public String getPaymentWay()  {
    return paymentWay;
  }

  public Employee() {
      this.uniqueID = 0;
  }

  public void setSales(Sale sale) {
    this.sales.add(sale);
  }

  public ArrayList<Sale> getSales() {
    return sales;
  }

  public String printEmployee () {
    return "\nNome: " + this.name +
      "\nEndereço: " + this.address +
      "\nTipo de pagamento: " + this.paymentType +
      "\nID: " + this.uniqueID;
  }
}
