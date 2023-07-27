package br.com.santanderdevweek.domain.models

data class Santander(
    val id:Int,
    val name: String,
    val account: Account,
    val card: Card,
    val features: List<Feature>,
    val news: List<News>
)
