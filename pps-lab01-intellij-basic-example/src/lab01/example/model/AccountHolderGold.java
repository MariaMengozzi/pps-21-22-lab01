package lab01.example.model;

/**
 * This class represents the account holder concept.
 * That is: a person that can subscribe a bank account.
 *
 * Each account holder has a name, a surname and an ID (unique in the bank system)
 */
public class AccountHolderGold extends AccountHolder{

    public AccountHolderGold(String name, String surname, int id) {
        super(name, surname, id);
    }
}
