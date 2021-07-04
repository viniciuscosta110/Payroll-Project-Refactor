package Classes;

import java.util.LinkedList;

public class Hourly extends Employee {
  LinkedList<TimeCard> timeCards = new LinkedList<>();
  protected Double hour_salary;

  public void setHour_salary(Double hour_salary) {
      this.hour_salary = hour_salary;
  }

  public Double getHour_salary() {
      return hour_salary;
  }

  public void getWorked_week_time(TimeCard timeCard)
  {
    timeCard.setWorked_week_time(timeCards);
  }

  public void setTimeCard(TimeCard timecard)
  {
    getWorked_week_time(timecard);
    timeCards.add(timecard);
  }

  public String printEmployee (){
      return "\nNome: " + this.name +
      "\nEndereço: " + this.address +
      "\nTipo de pagamento: " + this.payment_type +
      "\nID: " + this.uniqueID +
      "\nSalário por hora: " + this.hour_salary;
  }
}