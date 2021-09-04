package tv.codealong.tutorials.springboot.thenewboston.service

import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import tv.codealong.tutorials.springboot.thenewboston.datasource.BankDataSource
import tv.codealong.tutorials.springboot.thenewboston.models.Bank

internal class BankServiceTest {

    private val dataSource: BankDataSource = mockk(relaxed = true)
    private val bankService: BankService = BankService(dataSource)

    @Test
    fun `should call its data source to retrieve banks`() {
        // when
        bankService.getBanks()
        
        // then
        verify(exactly = 1) { dataSource.getBanks() }
    }

    @Test
    fun `should call its data source to add new banks with account number`() {
        val newBank = Bank("123", 12.0, 77)

        // when
        bankService.addBank(newBank)

        // then
        verify(exactly = 1) { dataSource.addBank(newBank) }
    }
}