package Classes;

import java.util.*;

public class States {
  private PaymentSchedule paymentSchedule = new PaymentSchedule();
  private LinkedList<Employee> employees = new LinkedList<>();
  private LinkedList<Syndicate> syndicates = new LinkedList<>();
  private int employees_counter = 0;
  private int syndicates_counter = -1;

  public void setEmployees(LinkedList<Employee> employees) {
    this.employees = employees;
  }

  public LinkedList<Employee> getEmployees() {
    return employees;
  }

  public void setPaymentSchedule(PaymentSchedule paymentSchedule) {
    this.paymentSchedule = paymentSchedule;
  }

  public PaymentSchedule getPaymentSchedule() {
    return paymentSchedule;
  }

  public void setSyndicates(LinkedList<Syndicate> syndicates) {
    this.syndicates = syndicates;
  }

  public LinkedList<Syndicate> getSyndicates() {
    return syndicates;
  }

  public void setEmployees_counter(int employees_counter) {
    this.employees_counter = employees_counter;
  }
  
  public int getEmployees_counter() {
    return employees_counter;
  }

  public void setSyndicates_counter(int syndicates_counter) {
    this.syndicates_counter = syndicates_counter;
  }

  public int getSyndicates_counter() {
    return syndicates_counter;
  }

  public States() {

  }

  public States(PaymentSchedule paymentSchedule, LinkedList<Employee> employees, LinkedList<Syndicate> syndicates, int employees_counter, int syndicates_counter) {
    this.paymentSchedule = paymentSchedule;
    this.employees = employees;
    this.syndicates = syndicates;
    this.employees_counter = employees_counter;
    this.syndicates_counter = syndicates_counter;
  }  
}
