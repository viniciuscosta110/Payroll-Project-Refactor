package Classes;

import java.time.*;
import java.util.*;

public class PaymentSchedule {
  ArrayList<String> schedules = new ArrayList<>();

  public Boolean checkMonthlyPayment() {
    LocalDate today = LocalDate.now();
    Boolean flag = false;

    if(today.getDayOfMonth() == today.lengthOfMonth() - 2) {
      if(today.getDayOfWeek() == DayOfWeek.FRIDAY) {
        flag = true;
      }
    }

    if(today.getDayOfMonth() == today.lengthOfMonth())
    {
      if(!(today.getDayOfWeek().equals(DayOfWeek.SATURDAY)) && !(today.getDayOfWeek().equals(DayOfWeek.SUNDAY)))
      {
        flag = true;
      }
    }

    return flag;
  }

  private PaymentSchedule() {
    String Default = "mensal $";
    this.schedules.add(Default);
    
    Default = "semanal 1 sexta";
    this.schedules.add(Default);
    
    Default = "semanal 2 sexta";
    this.schedules.add(Default);
  }
}