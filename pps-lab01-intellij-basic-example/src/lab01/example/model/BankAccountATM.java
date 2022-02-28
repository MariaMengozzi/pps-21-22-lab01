package lab01.example.model;

public interface BankAccountATM extends BankAccount{

    /**
     * Allows the deposit with ATM of an amount on the account, if the given userID corresponds to the register holder ID
     * of the bank account. This ID acts like an "identification token" .
     *
     * @param userID the id of the user that wants do the deposit
     * @param amount the amount of the deposit
     */
    void depositWithATM(int userID, double amount);
}
