package sk.pattern.aggregator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import sk.pattern.aggregator.Aggregator;
import sk.pattern.aggregator.Product;
import sk.pattern.aggregator.ProductInformationClient;
import sk.pattern.aggregator.ProductInventoryClient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Test Aggregation of domain objects
 */
public class AggregatorTest {

  @InjectMocks
  private Aggregator aggregator;

  @Mock
  private ProductInformationClient informationClient;

  @Mock
  private ProductInventoryClient inventoryClient;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  /**
   * Tests getting the data for a desktop client
   */
  @Test
  public void testGetProduct() {
    String title = "The Product Title.";
    int inventories = 5;

    when(informationClient.getProductTitle()).thenReturn(title);
    when(inventoryClient.getProductInventories()).thenReturn(inventories);

    Product testProduct = aggregator.getProduct();

    assertEquals(title, testProduct.getTitle());
    assertEquals(inventories, testProduct.getProductInventories());
  }

}
