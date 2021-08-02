package Classes;

public class Sale {

  String date;
  Double price;
  Boolean flag = true;

  public void setDate(String date) {
    this.date = date;
  }

  public String getDate() {
    return date;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Double getPrice() {
    return price;
  }
  
  public void setFlag(Boolean flag) {
    this.flag = flag;
  }

  public Boolean getFlag() {
    return flag;
  }

  public Sale(String date, Double price) {
    this.date = date;
    this.price = price;
  }

  public Sale() {
    
  }
}
