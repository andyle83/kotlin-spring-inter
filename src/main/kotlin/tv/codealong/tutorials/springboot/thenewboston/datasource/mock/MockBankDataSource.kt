package tv.codealong.tutorials.springboot.thenewboston.datasource.mock

import org.springframework.stereotype.Repository
import tv.codealong.tutorials.springboot.thenewboston.datasource.BankDataSource
import tv.codealong.tutorials.springboot.thenewboston.models.Bank

@Repository
class MockBankDataSource : BankDataSource {

    override fun getBanks(): Collection<Bank> {
        TODO("Not yet implemented")
    }

}