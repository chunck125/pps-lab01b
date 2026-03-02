package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {

    public static final int DEPOSIT_AMOUNT = 1000;
    private SilverBankAccount silverAccount;
    private GoldBankAccount goldAccount;

    @BeforeEach
    void init(){
        BankAccount coreAccount = new CoreBankAccount();
        this.silverAccount = new SilverBankAccount(coreAccount);
        this.goldAccount = new GoldBankAccount(coreAccount);
    }

    @Test
    public void testInitiallyEmpty() {
        assertEquals(0, this.silverAccount.getBalance());
    }

    @Test
    public void testCanDeposit() {
        this.silverAccount.deposit(DEPOSIT_AMOUNT);
        assertEquals(DEPOSIT_AMOUNT, this.silverAccount.getBalance());
    }

    @Test
    public void testCanWithdraw() {
        int withdrawAmount = 200;
        this.silverAccount.deposit(DEPOSIT_AMOUNT);
        this.silverAccount.withdraw(withdrawAmount);
        assertEquals(DEPOSIT_AMOUNT - (withdrawAmount + 1), this.silverAccount.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable() {
        int withdrawAmount = 200;
        this.silverAccount.deposit(DEPOSIT_AMOUNT);
        assertThrows(IllegalStateException.class, () -> this.silverAccount.withdraw(DEPOSIT_AMOUNT + withdrawAmount));
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
