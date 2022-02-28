import lab01.example.model.AccountHolder;
import lab01.example.model.AccountHolderGold;
import lab01.example.model.SimpleBankAccount;
import lab01.example.model.SimpleBankAccountGoldHolder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The test suite for testing the SimpleBankAccount with ATM implementation
 */
class SimpleBankAccountGoldUserTest extends AbstractSimpleBankAccountTest{

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolderGold("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccountGoldHolder(accountHolder, 0);
    }

    @Test
    void testRedBalance(){
        bankAccount.deposit(accountHolder.getId(), 100);
        bankAccount.withdraw(accountHolder.getId(), 110);
        assertEquals(-10, bankAccount.getBalance());
    }

}
