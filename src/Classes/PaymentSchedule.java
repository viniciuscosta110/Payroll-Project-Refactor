package Classes;

/**
 * PaymentSchedule
 */
public class PaymentSchedule {
  Boolean monthly;
  int day;
  String weekDay;
  String frequency;

  public void setDay(int day) {
    this.day = day;
  }

  public int getDay() {
    return day;
  }

  public void setFrequency(String frequency) {
    this.frequency = frequency;
  }

  public String getFrequency() {
    return frequency;
  }

  public void setMonthly(Boolean monthly) {
    this.monthly = monthly;
  }

  public Boolean getMonthly() {
    return monthly;
  }

  public void setWeekDay(String weekDay) {
    this.weekDay = weekDay;
  }

  public String getWeekDay() {
    return weekDay;
  }

  public PaymentSchedule(){

  }
}