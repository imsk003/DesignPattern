
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sk.pattern.event.domain.Account;
import sk.pattern.event.event.AccountCreateEvent;
import sk.pattern.event.event.MoneyDepositEvent;
import sk.pattern.event.event.MoneyTransferEvent;
import sk.pattern.event.processor.DomainEventProcessor;
import sk.pattern.event.state.AccountAggregate;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Intergartion Test for Event Sourcing state recovery
 *
 * Created by Serdar Hamzaogullari on 19.08.2017.
 */
//public class IntegrationTest {
//
//  /**
//   * The Domain event processor.
//   */
//  private DomainEventProcessor eventProcessor;
//
//  /**
//   * Initialize.
//   */
//  @BeforeEach
//  public void initialize() {
//    eventProcessor = new DomainEventProcessor();
//  }
//
//  /**
//   * Test state recovery.
//   */
//  @Test
//  public void testStateRecovery() {
//    eventProcessor.reset();
//
//    eventProcessor.process(new AccountCreateEvent(
//        0, new Date().getTime(), ACCOUNT_OF_DAENERYS, "Daenerys Targaryen"));
//
//    eventProcessor.process(new AccountCreateEvent(
//        1, new Date().getTime(), ACCOUNT_OF_JON, "Jon Snow"));
//
//    eventProcessor.process(new MoneyDepositEvent(
//        2, new Date().getTime(), ACCOUNT_OF_DAENERYS,  new BigDecimal("100000")));
//
//    eventProcessor.process(new MoneyDepositEvent(
//        3, new Date().getTime(), ACCOUNT_OF_JON,  new BigDecimal("100")));
//
//    eventProcessor.process(new MoneyTransferEvent(
//        4, new Date().getTime(), new BigDecimal("10000"), ACCOUNT_OF_DAENERYS,
//        ACCOUNT_OF_JON));
//
//    Account accountOfDaenerysBeforeShotDown = AccountAggregate.getAccount(ACCOUNT_OF_DAENERYS);
//    Account accountOfJonBeforeShotDown = AccountAggregate.getAccount(ACCOUNT_OF_JON);
//
//    AccountAggregate.resetState();
//
//    eventProcessor = new DomainEventProcessor();
//    eventProcessor.recover();
//
//    Account accountOfDaenerysAfterShotDown = AccountAggregate.getAccount(ACCOUNT_OF_DAENERYS);
//    Account accountOfJonAfterShotDown = AccountAggregate.getAccount(ACCOUNT_OF_JON);
//
//    assertEquals(accountOfDaenerysBeforeShotDown.getMoney(),
//        accountOfDaenerysAfterShotDown.getMoney());
//    assertEquals(accountOfJonBeforeShotDown.getMoney(), accountOfJonAfterShotDown.getMoney());
//  }
//
//}