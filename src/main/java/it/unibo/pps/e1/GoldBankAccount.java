package it.unibo.pps.e1;

public class GoldBankAccount {

    private final BankAccount base;

    public GoldBankAccount(BankAccount base) {
        this.base = base;
    }
    public void deposit(int amount) { base.deposit(amount); }
    public int getBalance() { return base.getBalance(); }
    public void withdraw(int amount) {
        if (this.getBalance() + 500 < amount) {
            throw new IllegalStateException();
        }
        base.withdraw(amount);
    }
}
