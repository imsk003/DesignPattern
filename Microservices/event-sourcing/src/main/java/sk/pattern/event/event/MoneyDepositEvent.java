package sk.pattern.event.event;

import java.math.BigDecimal;

import sk.pattern.event.domain.Account;
import sk.pattern.event.state.AccountAggregate;

/**
 * This is the class that implements money deposit event.
 * Holds the necessary info for a money deposit event.
 * Implements the process function that finds the event related
 * domain objects and calls the related domain object's handle event functions
 *
 * Created by Serdar Hamzaogullari on 06.08.2017.
 */
public class MoneyDepositEvent extends DomainEvent {

  private final BigDecimal money;
  private final int accountNo;

  /**
   * Instantiates a new Money deposit event.
   *
   * @param sequenceId the sequence id
   * @param createdTime the created time
   * @param accountNo the account no
   * @param money the money
   */
  public MoneyDepositEvent(long sequenceId, long createdTime, int accountNo, BigDecimal money) {
    super(sequenceId, createdTime, "MoneyDepositEvent");
    this.money = money;
    this.accountNo = accountNo;
  }

  /**
   * Gets money.
   *
   * @return the money
   */
  public BigDecimal getMoney() {
    return money;
  }

  /**
   * Gets account no.
   *
   * @return the account no
   */
  public int getAccountNo() {
    return accountNo;
  }

  @Override
  public void process() {
    Account account = AccountAggregate.getAccount(accountNo);
    if (account == null) {
      throw new RuntimeException("Account not found");
    }
    account.handleEvent(this);
  }
}
