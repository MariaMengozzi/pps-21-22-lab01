package lab01.example.model;

/**
 * This class represent a particular instance of a BankAccount.
 * In particular, a Simple Bank Account allows always the deposit
 * while the withdrawal is allowed only if the balance greater or equal the withdrawal amount
 */
public class SimpleBankAccountWithAtm extends AbstractSimpleBankAccount implements BankAccountATM {

    private static final int FEE = 1;

    public SimpleBankAccountWithAtm(final AccountHolder holder, final double balance) {
        super(holder, balance);
    }

    @Override
    public void depositWithATM(final int userID, final double amount){
        if (checkUser(userID)) {
            this.balance = this.balance + amount - FEE;
        }
    }

    @Override
    public void withdrawWithATM(final int userID, final double amount) {
        if (!isWithdrawAllowed(amount)){
            throw new ArithmeticException();
        }
        if (checkUser(userID) && isWithdrawAllowed(amount)) {
            this.balance = this.balance - amount - FEE;
        }
    }

    @Override
    public void withdraw(int userID, double amount) {
        if (!isWithdrawAllowed(amount)){
            throw new ArithmeticException();
        }
        super.withdraw(userID, amount);
    }

    @Override
    public boolean isGold() {
        return false;
    }
}
