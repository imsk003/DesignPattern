package sk.pattern.event.app;


import java.math.BigDecimal;
import java.util.Date;

import sk.pattern.event.event.AccountCreateEvent;
import sk.pattern.event.event.MoneyDepositEvent;
import sk.pattern.event.event.MoneyTransferEvent;
import sk.pattern.event.processor.DomainEventProcessor;
import sk.pattern.event.state.AccountAggregate;

public class App {
  /**
   * The constant ACCOUNT OF DAENERYS.
   */
  public static final int ACCOUNT_OF_SK = 1;
  /**
   * The constant ACCOUNT OF JON.
   */
  public static final int ACCOUNT_OF_AK = 2;

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {

    DomainEventProcessor eventProcessor = new DomainEventProcessor();

    System.out.println("Running the system first time............");

    eventProcessor.reset();

    System.out.println("Creating the accounts............");

    eventProcessor.process(new AccountCreateEvent(
        0, new Date().getTime(), ACCOUNT_OF_SK, "SK"));

    eventProcessor.process(new AccountCreateEvent(
        1, new Date().getTime(), ACCOUNT_OF_AK, "AK"));

    System.out.println("Do some money operations............");

    eventProcessor.process(new MoneyDepositEvent(
        2, new Date().getTime(), ACCOUNT_OF_SK,  new BigDecimal("100000")));

    eventProcessor.process(new MoneyDepositEvent(
        3, new Date().getTime(), ACCOUNT_OF_AK,  new BigDecimal("100")));

    eventProcessor.process(new MoneyTransferEvent(
        4, new Date().getTime(), new BigDecimal("10000"), ACCOUNT_OF_SK,
        ACCOUNT_OF_AK));

    System.out.println("...............State:............");
    System.out.println(AccountAggregate.getAccount(ACCOUNT_OF_SK).toString());
    System.out.println(AccountAggregate.getAccount(ACCOUNT_OF_AK).toString());
    System.out.println("At that point system had a shut down, state in memory is cleared............");

    AccountAggregate.resetState();

    System.out.println("Recover the system by the events in journal file............");

    eventProcessor = new DomainEventProcessor();
    eventProcessor.recover();

    System.out.println("...............Recovered State:............");
    System.out.println(AccountAggregate.getAccount(ACCOUNT_OF_SK).toString());
    System.out.println(AccountAggregate.getAccount(ACCOUNT_OF_AK).toString());
  }


}
