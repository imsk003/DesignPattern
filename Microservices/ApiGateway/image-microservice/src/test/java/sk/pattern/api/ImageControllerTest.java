package sk.pattern.api;

import org.junit.jupiter.api.Test;

import sk.pattern.api.ImageController;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for Image Rest Controller
 */
public class ImageControllerTest {
  @Test
  public void testGetImagePath() {
    ImageController imageController = new ImageController();

    String imagePath = imageController.getImagePath();

    assertEquals("/product-image.png", imagePath);
  }
}
