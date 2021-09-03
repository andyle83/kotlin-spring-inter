package tv.codealong.tutorials.springboot.thenewboston.service

import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import tv.codealong.tutorials.springboot.thenewboston.datasource.BankDataSource

internal class BankServiceTest {

    private val dataSource: BankDataSource = mockk()
    private val bankService: BankService = BankService(dataSource)

    @Test
    fun `should call its data source to retrieve banks`() {
        // when
        val banks = bankService.getBanks()
        
        // then
        verify(exactly = 1) { dataSource.getBanks() }
    }
}