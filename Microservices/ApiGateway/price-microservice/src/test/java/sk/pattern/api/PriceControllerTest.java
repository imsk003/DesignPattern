package sk.pattern.api;

import org.junit.jupiter.api.Test;

import sk.pattern.api.PriceController;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriceControllerTest {
  @Test
  public void testgetPrice() {
    PriceController priceController = new PriceController();

    String price = priceController.getPrice();

    assertEquals("20", price);
  }
}
