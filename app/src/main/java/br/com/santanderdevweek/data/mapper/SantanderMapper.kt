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
    id = id, number = number, agency = agency, balance = balance, limit = limit
)

internal fun CardResponse.toCard() = Card(
    id = id, number = number, limit = limit
)

internal fun FeatureResponse.toFeature() = Feature(
    id = id, icon = icon, description = description
)

internal fun NewsResponse.toNews() = News(
    id = id, icon = icon, description = description
)

internal fun SantanderResponse.toSantander() = Santander(
    id = id,
    name = name,
    account = account.toAccount(),
    card = card.toCard(),
    features = features.map { it.toFeature() },
    news = news.map { it.toNews() }
)