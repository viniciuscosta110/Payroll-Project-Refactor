public class Employee {
    private String name;
    private String address;
    private int commissioned;
    private int uniqueID;

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCommissioned(int commissioned) {
        this.commissioned = commissioned;
    }

    public void setUniqueID(int uniqueID) {
        this.uniqueID = uniqueID;
    }

    public String getAddress() {
        return address;
    }

    public int getCommissioned() {
        return commissioned;
    }

    public String getName() {
        return name;
    }

    public int getUniqueID() {
        return uniqueID;
    }

    public Employee (String name, String address, int commissioned) {
        this.name = name;
        this.address = address;
        this.commissioned = commissioned;
    }

    public Employee()
    {
        this.uniqueID = 0;
    }

    public String printEmployee (){
        return "\nName: " + this.name +
        "\nAddress: " + this.address +
        "\nID: " + this.uniqueID +
        "\nCommissioned: " + this.commissioned + "\n";
    }
}
