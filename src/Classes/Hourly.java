package Classes;

import java.util.LinkedList;

public class Hourly extends Employee {
  LinkedList<TimeCard> timeCards = new LinkedList<>();
  protected Double hour_salary;

  public void setHour_salary(Double hour_salary) 
  {
      this.hour_salary = hour_salary;
  }

  public Double getHour_salary() 
  {
      return hour_salary;
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
    getWorked_time();
  }

  public void paymentDefault()
  {
    System.out.println("ID do funcionário: "+ this.uniqueID);
    System.out.println("Nome do funcionário: "+ this.name);
    System.out.println("Método de envio: " + this.paymentWay);
  }

  public String printEmployee ()
  {
      return "\nNome: " + this.name +
      "\nEndereço: " + this.address +
      "\nTipo de pagamento: " + this.paymentType +
      "\nVia de pagamento: " + this.paymentWay +
      "\nSalário por hora: " + this.hour_salary +
      "\nID: " + this.uniqueID + "\n";
  }
}