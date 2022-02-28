import lab01.example.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The test suite for testing the SimpleBankAccount with ATM implementation
 */
class SimpleBankAccountWithAtmOperationTest{

    private static final int FEE = 1;

    protected AccountHolder accountHolder;
    protected BankAccountATM bankAccount;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccountWithAtm(accountHolder, 0);
    }

    @Test
    void testInitialBalance() {
        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    void testDepositWithAtm() {
        bankAccount.depositWithATM(accountHolder.getId(), 100);
        assertEquals(100 - FEE, bankAccount.getBalance());
    }

    @Test
    void testWrongDepositWithATM() {
        bankAccount.depositWithATM(accountHolder.getId(), 100);
        bankAccount.deposit(2, 50);
        assertEquals(100 - FEE, bankAccount.getBalance());
    }

    @Test
    void testWithdrawWithATM() {
        bankAccount.depositWithATM(accountHolder.getId(), 100);
        bankAccount.withdrawWithATM(accountHolder.getId(), 70);
        assertEquals(30 - 2*FEE , bankAccount.getBalance());
    }

    @Test
    void testWrongWithdrawWithATM() {
        bankAccount.depositWithATM(accountHolder.getId(), 100);
        bankAccount.withdrawWithATM(2, 70);
        assertEquals(100 - FEE, bankAccount.getBalance());
    }
}
