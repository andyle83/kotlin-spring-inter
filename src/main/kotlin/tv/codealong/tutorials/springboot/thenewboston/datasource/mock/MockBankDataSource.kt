package tv.codealong.tutorials.springboot.thenewboston.datasource.mock

import org.springframework.stereotype.Repository
import tv.codealong.tutorials.springboot.thenewboston.datasource.BankDataSource
import tv.codealong.tutorials.springboot.thenewboston.models.Bank

@Repository
class MockBankDataSource : BankDataSource {

    val banks = listOf<Bank>(
        Bank(accountNumber = "1234", trust = 3.14, transactionFee = 10),
        Bank(accountNumber = "1111", trust = 3.12, transactionFee = 5),
        Bank(accountNumber = "2222", trust = 3.2, transactionFee = 15)
    )

    override fun getBanks(): Collection<Bank> = banks

}