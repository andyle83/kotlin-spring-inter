package tv.codealong.tutorials.springboot.thenewboston.models

/**
 * DTO class
 */
data class Bank(
    val accountNumber: String,
    val trust: Double,
    val transactionFee: Int
    )