package it.unibo.pps.e1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SilverBankAccountTest extends CoreBankAccountTest {
    private SilverBankAccount silverAccount;

    @BeforeEach
    void init(){
        account = new CoreBankAccount();
        this.silverAccount = new SilverBankAccount(account);
    }

    @Test
    public void testCanWithdraw() {
        int withdrawAmount = 200;
        this.silverAccount.deposit(DEPOSIT_AMOUNT);
        this.silverAccount.withdraw(withdrawAmount);
        Assertions.assertEquals(DEPOSIT_AMOUNT - (withdrawAmount + 1), this.silverAccount.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable() {
        int withdrawAmount = 200;
        this.silverAccount.deposit(DEPOSIT_AMOUNT);
        assertThrows(IllegalStateException.class, () -> this.silverAccount.withdraw(DEPOSIT_AMOUNT + withdrawAmount));
    }

}
