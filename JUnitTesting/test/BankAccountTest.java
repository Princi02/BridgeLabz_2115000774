import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    public void setup() {
        account = new BankAccount(100.0);
    }

    @Test
    public void testInitialBalance() {
        assertEquals(100.0, account.getBalance(), "Initial balance should be 100.0");
    }

    @Test
    public void testDeposit() {
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), "Balance should be updated after deposit");
    }

    @Test
    public void testWithdraw() {
        account.withdraw(30.0);
        assertEquals(70.0, account.getBalance(), "Balance should be updated after withdrawal");
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(200.0), "Should not allow withdrawal of more than balance");
    }

    @Test
    public void testNegativeDeposit() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-10.0), "Should not allow negative deposit");
    }

    @Test
    public void testNegativeWithdrawal() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-10.0), "Should not allow negative withdrawal");
    }
}
