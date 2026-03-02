package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {

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
        this.silverAccount.deposit(1000);
        assertEquals(1000, this.silverAccount.getBalance());
    }

    @Test
    public void testCanWithdraw() {
        this.silverAccount.deposit(1000);
        this.silverAccount.withdraw(200);
        assertEquals(799, this.silverAccount.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        this.silverAccount.deposit(1000);
        assertThrows(IllegalStateException.class, () -> this.silverAccount.withdraw(1200));
    }

    @Test
    public void testGoldAccountWithdraw() {
        this.goldAccount.deposit(1000);
        this.goldAccount.withdraw(200);
        assertEquals(800, this.goldAccount.getBalance());
    }
}
