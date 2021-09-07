package Classes;

import java.util.LinkedList;

public class Hourly extends Employee {
  LinkedList<TimeCard> timeCards = new LinkedList<>();
  protected Double hourSalary;

  public void setHourSalary(Double hourSalary) 
  {
      this.hourSalary = hourSalary;
  }

  public Double getHourSalary() 
  {
      return hourSalary;
  }

  public void getWorked_time()
  {
    for (TimeCard timeCard : timeCards) {
      System.out.println("Data adicionada: " + timeCard.getDate());
      System.out.println("Horas trabalhadas no dia: " + timeCard.getWorked_day_time() + "\n");
    }

    System.out.println("Horas trabalhadas na semana: " + timeCards.getLast().getWorked_week_time() + "\n");
  }

  public LinkedList<TimeCard> getTimeCards() {
    return timeCards;
  }

  public void setTimeCard(TimeCard timecard)
  {
    timeCards.add(timecard);
    timeCards.peekLast().setWorked_week_time(timeCards);
  }

  public void paymentDefault()
  {
    System.out.println("ID do funcionário: "+ this.uniqueID);
    System.out.println("Nome do funcionário: "+ this.name);
    System.out.println("Método de envio: " + this.paymentWay);
  }

  public Hourly() {
    
  }

  public Hourly(String name, String address, int uniqueID, int paymentSchedule, String paymentType, String paymentWay, Double hourSalary) {
    super(name, address, uniqueID, paymentSchedule, paymentType, paymentWay);
    this.hourSalary = hourSalary;
  }

  public String printEmployee ()
  {
      return "\nNome: " + this.name +
      "\nEndereço: " + this.address +
      "\nTipo de pagamento: " + this.paymentType +
      "\nVia de pagamento: " + this.paymentWay +
      "\nSalário por hora: " + this.hourSalary +
      "\nID: " + this.uniqueID + "\n";
  }
}