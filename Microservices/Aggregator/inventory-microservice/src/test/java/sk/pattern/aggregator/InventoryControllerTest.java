package sk.pattern.aggregator;

import org.junit.jupiter.api.Test;

import sk.pattern.aggregator.InventoryController;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test Inventory Rest Controller
 */
public class InventoryControllerTest {
  @Test
  public void testGetProductInventories() {
    InventoryController inventoryController = new InventoryController();

    int numberOfInventories = inventoryController.getProductInventories();

    assertEquals(5, numberOfInventories);
  }
}

