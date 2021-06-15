import domain.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class AccountTest {

    @Test
    void depositingNegativeNumberShouldReturnFalse() {

        //Arrange
        Account account = new Account("Nick", 12, 400);

        //Act
        boolean isDeposited = account.deposit(-12);

        //Assert
        assertFalse(isDeposited);
    }

    @Test
    void withdrawingNegativeAmountShouldReturnFalse() {
        Account account = new Account("Savannah", 13, 1500);
        boolean validWithdrawal = account.withdraw(-10, 1);
        assertFalse(validWithdrawal);
    }

    @Test
    void withdrawingNegativeFeeShouldReturnFalse() {
        Account account = new Account("Savannah", 13, 1500);
        boolean validWithdrawal = account.withdraw(100, -10);
        assertFalse(validWithdrawal);
    }
    @Test
    void withdrawingAmountExceedsBalanceShouldReturnFalse() {
        Account account = new Account("Savannah",13, 1500);
        boolean validWithdrawal = account.withdraw(1600, 10);
        assertFalse(validWithdrawal);
    }
    @Test
    void withdrawingGoodParametersShouldWithdrawCorrectAmount() {
        Account account = new Account("Savannah", 13, 1500);
        boolean validWithDrawal = account.withdraw(1000, 10);
        assertEquals(490, account.getBalance());
    }

    @Test
    void addingInterestShouldSetCorrectBalance() {
        Account account = new Account("Savannah", 13, 1500);
        account.addInterest();
        assertEquals(1567.5,account.getBalance());
    }

    @Test
    void getBalanceShouldReturnCorrectBalance() {
        Account account = new Account("Savannah", 13, 1750);
        assertEquals(1750, account.getBalance());
    }
}