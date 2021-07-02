package Classes;

public class Hourly extends Employee {
    protected Double hour_salary;

    public void setHour_salary(Double hour_salary) {
        this.hour_salary = hour_salary;
    }

    public Double getHour_salary() {
        return hour_salary;
    }

    public String printEmployee (){
        return "\nNome: " + this.name +
        "\nEndereço: " + this.address +
        "\nTipo de pagamento: " + this.payment_type +
        "\nID: " + this.uniqueID +
        "\nSalário por hora: " + this.hour_salary;
    }
}