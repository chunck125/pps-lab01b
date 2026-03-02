package it.unibo.pps.e1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public abstract class CoreBankAccountTest {
    protected static final int DEPOSIT_AMOUNT = 1000;
    protected BankAccount account;

    @Test
    public void testInitiallyEmpty() {
        Assertions.assertEquals(0, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        this.account.deposit(DEPOSIT_AMOUNT);
        Assertions.assertEquals(DEPOSIT_AMOUNT, this.account.getBalance());
    }
}
