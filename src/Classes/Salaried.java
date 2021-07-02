package Classes;

public class Salaried extends Employee {
    Double month_salary;
    Double commission = 0.0;
    
    public void setMonth_salary(Double month_salary) {
        this.month_salary = month_salary;
    }

    public Double getMonth_salary() {
        return month_salary;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }

    public Double getCommission() {
        return commission;
    }
}
