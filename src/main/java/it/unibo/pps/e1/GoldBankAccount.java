package it.unibo.pps.e1;

public class GoldBankAccount{

    public static final int OVERDRAFT_LIMIT = 500;
    private final BankAccount base;

    public GoldBankAccount(BankAccount base) {
        this.base = base;
    }
    public void deposit(int amount) { base.deposit(amount); }
    public int getBalance() { return base.getBalance(); }
    public void withdraw(int amount) {
        if (this.getBalance() + OVERDRAFT_LIMIT < amount) {
            throw new IllegalStateException();
        }
        base.withdraw(amount);
    }
}
