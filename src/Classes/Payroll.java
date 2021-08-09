package Classes;

import java.time.LocalDate;
import java.util.*;

public class Payroll {
  Scanner input = new Scanner(System.in);
  
  public static void verifyPayment(LinkedList<Employee> employees, LinkedList<Syndicate> syndicates, PaymentSchedule schedules){
    LocalDate today = LocalDate.now();
    Calendar calendar = Calendar.getInstance();

    for (String schedule : schedules.getSchedules()) {
      int i = 0;

      if(schedule.contains("semanal")) {
        String[] scheduleParts = schedule.split(" ");
        int paymentWeek = Integer.parseInt(scheduleParts[1]);
        int week = calendar.get(Calendar.WEEK_OF_MONTH);

        if(schedule.contains(today.getDayOfWeek().name())) {
          for (Employee employee : employees) {
            if(employee.getPaymentSchedule() == i) {
              if(employee.getPaymentType() == "Horista") {
                Hourly hourly = (Hourly)employee;
                hourly.paymentDefault();

                Double salary = calculateHourlySalary(hourly, syndicates);

                System.out.println("Salário: "+ salary + "\n");
              }
              else
              {
                Salaried salaried = (Salaried)employee;

                Double salary = salaried.getMonthSalary() * (0.25 * paymentWeek);
                salary = salary - calculateSyndicateFee(syndicates, employee);

                if(employee.getPaymentType() == "Assalariado comissionado") {    
                  salary = salary - salaried.getMonthSalary()/2;

                  if(week % 2 == 0) {
                    for(Sale sale : salaried.getSales()) {
                      if(sale.getFlag()) {
                        salary = salary + (salaried.getCommission()/100) * sale.getPrice();
                        sale.setFlag(false);
                      }
                    }
                  }
                }

                System.out.println("Salário: "+ salary + "\n");
              }
            }
          }
        }
      }
      else if(schedule.contains("mensal")) {
        Boolean flag = false;
        int week = calendar.get(Calendar.WEEK_OF_MONTH);

        if(schedule.contains("$")) {
          flag = schedules.checkMonthlyPayment();
        }
        
        if(flag || schedule.contains(Integer.toString(today.getDayOfMonth()))) {
          for (Employee employee : employees) {
            if(employee.getPaymentType() == "Horista") {
              Hourly hourly = (Hourly)employee;
              hourly.paymentDefault();

              Double salary = calculateHourlySalary(hourly, syndicates);

              System.out.println("Salário: "+ salary + "\n");
            }
            else
            {
              Salaried salaried = (Salaried)employee;

              Double salary = salaried.getMonthSalary();
              salary = salary - calculateSyndicateFee(syndicates, employee);
              
              if(employee.getPaymentType() == "Assalariado comissionado") {
                salary = salary - salaried.getMonthSalary()/2;
                
                if(week % 2 == 0) {
                  for(Sale sale : salaried.getSales()) {
                    if(sale.getFlag()) {
                      salary = salary + (salaried.getCommission()/100) * sale.getPrice();
                      sale.setFlag(false);
                    }
                  }
                }
              }

              System.out.println("Salário: "+ salary + "\n");
            }
          }
        }
      }

      i = i + 1;
    }

  }

  private static Double calculateHourlySalary(Hourly hourly, LinkedList<Syndicate> syndicates) {

    Double exceededTimePayment = (hourly.getHour_salary() * 1.5) * hourly.getTimeCards().getLast().getExceeded_time();
    Double salary = hourly.getTimeCards().getLast().getWorked_week_time() * hourly.getHour_salary() + exceededTimePayment;

    salary = salary - calculateSyndicateFee(syndicates, (Employee)hourly);

    return salary;
  }

  private static Double calculateSyndicateFee(LinkedList<Syndicate> syndicates, Employee employee) {
    Double fee = 0.0;

    for(Syndicate syndicate : syndicates) {
      if(syndicate.getEmployeeId() == employee.getUniqueID()) {
        fee = fee - syndicate.getSyndicate_fee();
        fee = fee - syndicate.getService_fee();
        break;
      }
    }

    return fee;
  }


}
