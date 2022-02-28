import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccount;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * The test suite for testing the SimpleBankAccount with ATM implementation
 */
class SimpleBankAccountWithAtmTest extends AbstractSimpleBankAccountTest{

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccountWithAtm(accountHolder, 0);
    }

    @Test
    void testWithdrawExceprion() {
        super.testWithdraw();
        assertThrows(ArithmeticException.class, ()->bankAccount.withdraw(accountHolder.getId(), 200));
    }
}
