package lab01.example.model;

/**
 * This class represent a particular instance of a BankAccount.
 * In particular, a Simple Bank Account allows always the deposit
 * while the withdrawal is allowed only if the balance greater or equal the withdrawal amount
 */
public class SimpleBankAccountGoldHolder extends SimpleBankAccount implements BankAccount {


    public SimpleBankAccountGoldHolder(AccountHolder holder, double balance) {
        super(holder, balance);
    }

    @Override
    public void withdraw(final int userID, final double amount) {
        if (checkUser(userID)) {
            this.balance -= amount;
        }
    }
}
