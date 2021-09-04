package tv.codealong.tutorials.springboot.thenewboston.datasource.mock

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import tv.codealong.tutorials.springboot.thenewboston.models.Bank

internal class MockBankDataSourceTest {

    private val mockDataSource = MockBankDataSource()

    @Test
    fun `should provide a collection of banks`() {
        // when
        val banks = mockDataSource.getBanks()
        
        // then
        // assertThat(banks).isNotEmpty
        assertThat(banks.size).isGreaterThanOrEqualTo(3)
    }
    
    @Test
    fun `should provide some mock data`() {
        // when
        val banks = mockDataSource.getBanks()
        
        // then
        assertThat(banks).allMatch { it.accountNumber.isNotBlank() }
        assertThat(banks).allMatch { it.trust != 0.0 }
        assertThat(banks).allMatch { it.transactionFee != 0 }
    }

    @Test
    fun `should provide data with unique account numbers`() {
        // when
        val banks = mockDataSource.getBanks()

        // then
        assertThat(banks.distinctBy { it.accountNumber }).hasSameSizeAs(banks)
    }

    @Test
    fun `should provide data with an account number`() {
        val accountNumber = "1234"

        // when
        val existedBank = mockDataSource.getBank(accountNumber)

        // then
        assertNotNull(existedBank)
        assertEquals(existedBank.accountNumber, accountNumber)
    }

    @Test
    fun `should throws an exception when provide an invalid account number`() {
        val invalidAccountNumber = "an_invalid_account"

        // when / then
        try {
            mockDataSource.getBank(invalidAccountNumber)
        } catch (e: NoSuchElementException) {
            assertEquals(e.message, "Could not find a bank with account number $invalidAccountNumber")
        }
    }

    @Test
    fun `should allow to add new bank`() {
        val newBank = Bank(accountNumber = "7777", trust = 3.14, transactionFee = 10)

        // when
        mockDataSource.addBank(newBank)

        // then
        assertThat(mockDataSource.getBanks().contains(newBank))
    }

    @Test
    fun `should throw an exception when trying to add an existing bank account`() {
        val invalidBank = Bank(accountNumber = "1234", trust = 3.14, transactionFee = 10)

        try {
            mockDataSource.addBank(invalidBank)
        } catch (e: IllegalArgumentException) {
            assertEquals(e.message, "Bank with account number ${invalidBank.accountNumber} is already existed")
        }
    }
}