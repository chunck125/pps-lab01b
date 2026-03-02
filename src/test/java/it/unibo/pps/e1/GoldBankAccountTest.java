package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoldBankAccountTest extends CoreBankAccountTest{
    private GoldBankAccount goldAccount;

    @BeforeEach
    public void init() {
        account = new CoreBankAccount();
        this.goldAccount = new GoldBankAccount(account);
    }

    @Test
    public void testGoldAccountWithdraw() {
        int withdrawAmount = 200;
        this.goldAccount.deposit(DEPOSIT_AMOUNT);
        this.goldAccount.withdraw(withdrawAmount);
        assertEquals(DEPOSIT_AMOUNT - withdrawAmount, this.goldAccount.getBalance());
    }

    @Test
    public void testGoldAccountWithdrawMoreThanAvailable() {
        int withdrawAmount = 1200;
        this.goldAccount.deposit(DEPOSIT_AMOUNT);
        this.goldAccount.withdraw(withdrawAmount);
        assertEquals(DEPOSIT_AMOUNT - withdrawAmount, this.goldAccount.getBalance());
    }

}
