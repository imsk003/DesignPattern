package sk.pattern.ambassador;

import static java.lang.Thread.sleep;


import sk.pattern.ambassador.util.RandomProvider;

/**
 * A remote legacy application represented by a Singleton implementation.
 */
public class RemoteService implements RemoteServiceInterface {
  static final int THRESHOLD = 200;
  private static RemoteService service = null;
  private final RandomProvider randomProvider;

  static synchronized RemoteService getRemoteService() {
    if (service == null) {
      service = new RemoteService();
    }
    return service;
  }

  private RemoteService() {
    this(Math::random);
  }

  /**
   * This constuctor is used for testing purposes only.
   */
  RemoteService(RandomProvider randomProvider) {
    this.randomProvider = randomProvider;
  }
 
  @Override
  public long doRemoteFunction(int value) {

    long waitTime = (long) Math.floor(randomProvider.random() * 1000);

    try {
      sleep(waitTime);
    } catch (InterruptedException e) {
    	System.out.println("Thread sleep state interrupted " + e);
    }
    return waitTime <= THRESHOLD ? value * 10 : FAILURE;
  }
}
