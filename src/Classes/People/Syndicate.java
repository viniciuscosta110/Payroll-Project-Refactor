package Classes.People;

public class Syndicate {
  private Double syndicate_fee;
  private Double service_fee;
  private int syndicate_id;
  private int employeeId;

  public void setService_fee(Double service_fee) 
  {
    this.service_fee = service_fee;
  }

  public double getService_fee() 
  {
    return service_fee;
  }

  public void setSyndicate_fee(Double syndicate_fee) 
  {
    this.syndicate_fee = syndicate_fee;
  }

  public double getSyndicate_fee() 
  {
    return syndicate_fee;
  }

  public void setSyndicate_id(int syndicate_id)
  {
    this.syndicate_id = syndicate_id;
  }

  public int getSyndicate_id()
  {
    return syndicate_id;
  }

  public void setEmployeeId(int employeeId) 
  {
    this.employeeId = employeeId;
  }

  public int getEmployeeId()
  {
    return employeeId;
  }

  public Syndicate()
  {

  }

  public String printSyndicate()
  {
    return "\nTaxa sindical: " + this.syndicate_fee +
      "\nTaxa por serviço: " + this.service_fee +
      "\nID sindical: " + this.syndicate_id;
  }
}
