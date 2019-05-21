package sk.pattern.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class ApiGateway {

  @Resource
  private ImageClient imageClient;

  @Resource
  private PriceClient priceClient;

  /**
   * Retrieves product information that desktop clients need
   * @return Product information for clients on a desktop
   */
  @RequestMapping("/desktop")
  public DesktopProduct getProductDesktop() {
    DesktopProduct desktopProduct = new DesktopProduct();
    desktopProduct.setImagePath(imageClient.getImagePath());
    desktopProduct.setPrice(priceClient.getPrice());
    return desktopProduct;
  }

  
  @RequestMapping("/mobile")
  public MobileProduct getProductMobile() {
    MobileProduct mobileProduct = new MobileProduct();
    mobileProduct.setPrice(priceClient.getPrice());
    return mobileProduct;
  }
}
