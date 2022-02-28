package lab01.example.model;

/**
 * This class represent a particular instance of a BankAccount.
 * In particular, a Simple Bank Account allows always the deposit
 * while the withdrawal is allowed only if the balance greater or equal the withdrawal amount
 */
public abstract class AbstractSimpleBankAccount implements BankAccount {

    protected double balance;
    protected final AccountHolder holder;

    public AbstractSimpleBankAccount(final AccountHolder holder, final double balance) {
        this.holder = holder;
        this.balance = balance;
    }
    @Override
    public AccountHolder getHolder(){
        return this.holder;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(final int userID, final double amount) {
        if (checkUser(userID)) {
            this.balance += amount;
        }
    }

    @Override
    public void withdraw(final int userID, final double amount) {
        if (checkUser(userID)) {
            if(isGold() || isWithdrawAllowed(amount)) {
                this.balance -= amount;
            }
        }
    }

    public abstract boolean isGold();

    protected boolean isWithdrawAllowed(final double amount){
        return this.balance >= amount;
    }

    protected boolean checkUser(final int id) {
        return this.holder.getId() == id;
    }
}
