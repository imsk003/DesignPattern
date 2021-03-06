package sk.pattern.event.domain;

import java.math.BigDecimal;

import sk.pattern.event.event.AccountCreateEvent;
import sk.pattern.event.event.MoneyDepositEvent;
import sk.pattern.event.event.MoneyTransferEvent;
import sk.pattern.event.state.AccountAggregate;

public class Account {

 // private static final Logger LOGGER = LoggerFactory.getLogger(Account.class);

  private final int accountNo;
  private final String owner;
  private BigDecimal money;

  /**
   * Instantiates a new Account.
   *
   * @param accountNo the account no
   * @param owner the owner
   */
  public Account(int accountNo, String owner) {
    this.accountNo = accountNo;
    this.owner = owner;
    money = BigDecimal.ZERO;
  }

  /**
   * Gets account no.
   *
   * @return the account no
   */
  public int getAccountNo() {
    return accountNo;
  }

  /**
   * Gets owner.
   *
   * @return the owner
   */
  public String getOwner() {
    return owner;
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
   * Sets money.
   *
   * @param money the money
   */
  public void setMoney(BigDecimal money) {
    this.money = money;
  }


  /**
   * Copy account.
   *
   * @return the account
   */
  public Account copy() {
    Account account = new Account(accountNo, owner);
    account.setMoney(money);
    return account;
  }

  @Override
  public String toString() {
    return "Account{"
        + "accountNo=" + accountNo
        + ", owner='" + owner + '\''
        + ", money=" + money
        + '}';
  }

  private void depositMoney(BigDecimal money) {
    this.money = this.money.add(money);
  }

  private void withdrawMoney(BigDecimal money) {
    this.money = this.money.subtract(money);
  }

  private void handleDeposit(BigDecimal money, boolean realTime) {
    depositMoney(money);
    AccountAggregate.putAccount(this);
    if (realTime) {
    	System.out.println("Some external api for only realtime execution could be called here.");
    }
  }

  private void handleWithdrawal(BigDecimal money, boolean realTime) {
    if (this.money.compareTo(money) == -1) {
      throw new RuntimeException("Insufficient Account Balance");
    }

    withdrawMoney(money);
    AccountAggregate.putAccount(this);
    if (realTime) {
    	System.out.println("Some external api for only realtime execution could be called here.");
    }
  }

  /**
   * Handles the MoneyDepositEvent.
   *
   * @param moneyDepositEvent the money deposit event
   */
  public void handleEvent(MoneyDepositEvent moneyDepositEvent) {
    handleDeposit(moneyDepositEvent.getMoney(), moneyDepositEvent.isRealTime());
  }


  /**
   * Handles the AccountCreateEvent.
   *
   * @param accountCreateEvent the account create event
   */
  public void handleEvent(AccountCreateEvent accountCreateEvent) {
    AccountAggregate.putAccount(this);
    if (accountCreateEvent.isRealTime()) {
    	System.out.println("Some external api for only realtime execution could be called here.");
    }
  }

  /**
   * Handles transfer from account event.
   *
   * @param moneyTransferEvent the money transfer event
   */
  public void handleTransferFromEvent(MoneyTransferEvent moneyTransferEvent) {
    handleWithdrawal(moneyTransferEvent.getMoney(), moneyTransferEvent.isRealTime());
  }

  /**
   * Handles transfer to account event.
   *
   * @param moneyTransferEvent the money transfer event
   */
  public void handleTransferToEvent(MoneyTransferEvent moneyTransferEvent) {
    handleDeposit(moneyTransferEvent.getMoney(), moneyTransferEvent.isRealTime());
  }


}
