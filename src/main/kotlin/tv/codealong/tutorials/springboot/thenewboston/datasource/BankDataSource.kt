package tv.codealong.tutorials.springboot.thenewboston.datasource

import tv.codealong.tutorials.springboot.thenewboston.models.Bank

interface BankDataSource {

    fun getBanks(): Collection<Bank>

    fun getBank(accountNumber: String): Bank

    fun addBank(newBank: Bank) : Bank

    fun update(bank: Bank): Bank

}