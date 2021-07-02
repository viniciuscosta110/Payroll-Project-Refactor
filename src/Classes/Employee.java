package Classes;

public class Employee {
    protected String name;
    protected String address;
    protected int uniqueID;
    protected String payment_type;

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setUniqueID(int uniqueID) {
        this.uniqueID = uniqueID;
    }

    public int getUniqueID() {
        return uniqueID;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public Employee()
    {
        this.uniqueID = 0;
    }

    public String printEmployee (){
        return "\nNome: " + this.name +
        "\nEndereço: " + this.address +
        "\nTipo de pagamento: " + this.payment_type +
        "\nID: " + this.uniqueID;
    }
}
