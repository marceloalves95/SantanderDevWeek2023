package br.com.santanderdevweek.data.mapper

import br.com.santanderdevweek.data.models.AccountResponse
import br.com.santanderdevweek.data.models.CardResponse
import br.com.santanderdevweek.data.models.FeatureResponse
import br.com.santanderdevweek.data.models.NewsResponse
import br.com.santanderdevweek.data.models.SantanderResponse
import br.com.santanderdevweek.domain.models.Account
import br.com.santanderdevweek.domain.models.Card
import br.com.santanderdevweek.domain.models.Feature
import br.com.santanderdevweek.domain.models.News
import br.com.santanderdevweek.domain.models.Santander

internal fun AccountResponse.toAccount() = Account(
    number = number, agency = agency, balance = balance, limit = limit
)

internal fun CardResponse.toCard() = Card(
    number = number, limit = limit
)

internal fun FeatureResponse.toFeature() = Feature(
    icon = icon, description = description
)

internal fun NewsResponse.toNews() = News(
    icon = icon, description = description
)

internal fun SantanderResponse.toSantander() = Santander(
    name = name,
    account = account.toAccount(),
    card = card.toCard(),
    features  = features.map { it.toFeature() },
    news = news.map { it.toNews() }
)