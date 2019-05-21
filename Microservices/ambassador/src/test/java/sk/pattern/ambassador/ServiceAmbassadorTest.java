package sk.pattern.ambassador;

import org.junit.jupiter.api.Test;

import sk.pattern.ambassador.RemoteServiceInterface;
import sk.pattern.ambassador.ServiceAmbassador;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test for {@link ServiceAmbassador}
 */
public class ServiceAmbassadorTest {

  @Test
  public void test() {
    long result = new ServiceAmbassador().doRemoteFunction(10);
    assertTrue(result == 100 || result == RemoteServiceInterface.FAILURE);
  }
}
