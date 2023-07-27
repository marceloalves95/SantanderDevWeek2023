package br.com.santanderdevweek.domain.model

import br.com.santanderdevweek.domain.models.Account
import br.com.santanderdevweek.domain.models.Card
import br.com.santanderdevweek.domain.models.Feature
import br.com.santanderdevweek.domain.models.News
import br.com.santanderdevweek.domain.models.Santander

val dummyAccount = Account(
    id = 1,
    number = "01.097954-4",
    agency = "2030",
    balance = 624.12,
    limit = 1000.00
)

val dummyCard = Card(
    id = 1,
    number = "xxxx xxxx xxxx 1111",
    limit = 2000.00
)

val dummyFeature = Feature(
    id = 1,
    icon = "https://digitalinnovationone.github.io/santander-dev-week-2023-api/icons/pix.svg",
    description = "PIX"
)

val dummyNews = News(
    id = 1,
    icon = "https://digitalinnovationone.github.io/santander-dev-week-2023-api/icons/credit.svg",
    description = "O Santander tem soluções de crédito sob medida pra você. Confira!"
)

val dummySantander = Santander(
    id = 1,
    name = "Devweekerson",
    account = dummyAccount,
    card = dummyCard,
    features = listOf(
        dummyFeature,
        dummyFeature.copy(
            id = 2,
            icon = "https://digitalinnovationone.github.io/santander-dev-week-2023-api/icons/pay.svg",
            description = "Pagar"
        ),
        dummyFeature.copy(
            id = 3,
            icon = "https://digitalinnovationone.github.io/santander-dev-week-2023-api/icons/transfer.svg",
            description = "Transferir"
        ),
        dummyFeature.copy(
            id = 4,
            icon = "https://digitalinnovationone.github.io/santander-dev-week-2023-api/icons/account.svg",
            description = "Conta Corrente"
        ),
        dummyFeature.copy(
            id = 5,
            icon = "https://digitalinnovationone.github.io/santander-dev-week-2023-api/icons/cards.svg",
            description = "Cartões"
        )
    ),
    news = listOf(
        dummyNews,
        dummyNews.copy(
            id = 2,
            icon = "https://digitalinnovationone.github.io/santander-dev-week-2023-api/icons/insurance.svg",
            description = "Santander Seguro Casa, seu faz-tudo. Mais de 50 serviços pra você. Confira!"
        )
    )
)