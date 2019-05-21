package sk.pattern.aggregator;

//Encapsulates all the data for a Product that clients will request.
public class Product {

  
  private String title;


  
  private int productInventories;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getProductInventories() {
    return productInventories;
  }

  public void setProductInventories(int productInventories) {
    this.productInventories = productInventories;
  }

}
