package br.com.santanderdevweek.domain.models

data class Account(
    val id:Int,
    val number:String,
    val agency:String,
    val balance:Double,
    val limit:Double
)
