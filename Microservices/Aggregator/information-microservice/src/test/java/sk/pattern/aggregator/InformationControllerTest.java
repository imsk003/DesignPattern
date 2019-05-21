package sk.pattern.aggregator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import sk.pattern.aggregator.InformationController;

public class InformationControllerTest {

  @Test
  public void shouldGetProductTitle() {
    InformationController infoController = new InformationController();

    String title = infoController.getProductTitle();

    assertEquals("The Product Title.", title);
  }

}