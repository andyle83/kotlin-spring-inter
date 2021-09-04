package tv.codealong.tutorials.springboot.thenewboston.service

import org.springframework.stereotype.Service
import tv.codealong.tutorials.springboot.thenewboston.datasource.BankDataSource
import tv.codealong.tutorials.springboot.thenewboston.models.Bank

@Service
class BankService(private val dataSource: BankDataSource) {

    fun getBanks(): Collection<Bank> = dataSource.getBanks()

    fun getBank(accountNumber: String): Bank = dataSource.getBank(accountNumber)

    fun addBank(bank: Bank): Bank = dataSource.addBank(bank)

    fun updateBank(bank: Bank): Bank = dataSource.update(bank)
}