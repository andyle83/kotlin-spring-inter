package tv.codealong.tutorials.springboot.thenewboston.datasource.mock

import org.springframework.stereotype.Repository
import tv.codealong.tutorials.springboot.thenewboston.datasource.BankDataSource
import tv.codealong.tutorials.springboot.thenewboston.models.Bank

@Repository
class MockBankDataSource : BankDataSource {

    val banks = listOf<Bank>(Bank(accountNumber = "abc", trust = 0.0, transactionFee = 0))

    override fun getBanks(): Collection<Bank> = banks

}