package Classes;

import java.util.ArrayList;

public class Employee {
  protected String name;
  protected String address;
  protected int uniqueID;
  protected int paymentSchedule;
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

  public void setPaymentSchedule(int paymentSchedule) {
    this.paymentSchedule = paymentSchedule;
  }
  
  public int getPaymentSchedule() {
    return paymentSchedule;
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

  public void setSales(Sale sale) {
    this.sales.add(sale);
  }

  public ArrayList<Sale> getSales() {
    return sales;
  }

  public Employee() {
    this.uniqueID = 0;
}

  public Employee(String name, String address, int uniqueID, int paymentSchedule, String paymentType, String paymentWay) {
    this.name = name;
    this.address = address;
    this.uniqueID = uniqueID;
    this.paymentSchedule = paymentSchedule;
    this.paymentType = paymentType;
    this.paymentWay = paymentWay;
  }

  public void paymentDefault()
  {
    System.out.println("ID do funcionário: "+ this.uniqueID);
    System.out.println("Nome do funcionário: "+ this.name);
    System.out.println("Método de envio: " + this.paymentWay);
  }

  public String printEmployee () {
    return "\nNome: " + this.name +
      "\nEndereço: " + this.address +
      "\nTipo de pagamento: " + this.paymentType +
      "\nID: " + this.uniqueID;
  }
}
