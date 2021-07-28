package Classes.People;

public class Employee
{
  protected String name;
  protected String address;
  protected int uniqueID;
  protected String payment_type;
  protected String payment_way;

  public void setAddress(String address)
  {
    this.address = address;
  }

  public String getAddress()
  {
    return address;
  }

  public void setName(String name) 
  {
    this.name = name;
  }

  public String getName()
  {
    return name;
  }

  public void setUniqueID(int uniqueID) 
  {
    this.uniqueID = uniqueID;
  }

  public int getUniqueID() 
  {
    return uniqueID;
  }

  public void setPayment_type(String payment_type) 
  {
    this.payment_type = payment_type;
  }

  public String getPayment_type()
  {
      return payment_type;
  }

  public void setPayment_way(String payment_way) 
  {
    this.payment_way = payment_way;
  }

  public String getPayment_way() 
  {
    return payment_way;
  }

  public Employee()
  {
      this.uniqueID = 0;
  }

  public String printEmployee ()
  {
    return "\nNome: " + this.name +
      "\nEndereço: " + this.address +
      "\nTipo de pagamento: " + this.payment_type +
      "\nID: " + this.uniqueID;
  }
}
