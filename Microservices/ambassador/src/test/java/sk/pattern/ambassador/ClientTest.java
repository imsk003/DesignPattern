
package sk.pattern.ambassador;

import org.junit.jupiter.api.Test;

import sk.pattern.ambassador.Client;
import sk.pattern.ambassador.RemoteService;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test for {@link Client}
 */
public class ClientTest {

  @Test
  public void test() {

    Client client = new Client();
    long result = client.useService(10);

    assertTrue(result == 100 || result == RemoteService.FAILURE);
  }
}
