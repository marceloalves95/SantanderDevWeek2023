package br.com.santanderdevweek.domain.mock

import br.com.santanderdevweek.domain.models.Account
import br.com.santanderdevweek.domain.models.Card
import br.com.santanderdevweek.domain.models.Feature
import br.com.santanderdevweek.domain.models.News
import br.com.santanderdevweek.domain.models.Santander

val mockAccount = Account(
    id = 1,
    number = "01.097954-4",
    agency = "2030",
    balance = 624.12,
    limit = 1000.00
)

val mockCard = Card(
    id = 1,
    number = "xxxx xxxx xxxx 1111",
    limit = 2000.00
)

val mockFeature = Feature(
    id = 1,
    icon = "https://digitalinnovationone.github.io/santander-dev-week-2023-api/icons/pix.svg",
    description = "PIX"
)

val mockNews = News(
    id = 1,
    icon = "https://digitalinnovationone.github.io/santander-dev-week-2023-api/icons/credit.svg",
    description = "O Santander tem soluções de crédito sob medida pra você. Confira!"
)

val mockSantander = Santander(
    id = 1,
    name = "Devweekerson",
    account = mockAccount,
    card = mockCard,
    features = listOf(
        mockFeature,
        mockFeature.copy(
            id = 2,
            icon = "https://digitalinnovationone.github.io/santander-dev-week-2023-api/icons/pay.svg",
            description = "Pagar"
        ),
        mockFeature.copy(
            id = 3,
            icon = "https://digitalinnovationone.github.io/santander-dev-week-2023-api/icons/transfer.svg",
            description = "Transferir"
        ),
        mockFeature.copy(
            id = 4,
            icon = "https://digitalinnovationone.github.io/santander-dev-week-2023-api/icons/account.svg",
            description = "Conta Corrente"
        ),
        mockFeature.copy(
            id = 5,
            icon = "https://digitalinnovationone.github.io/santander-dev-week-2023-api/icons/cards.svg",
            description = "Cartões"
        )
    ),
    news = listOf(
        mockNews,
        mockNews.copy(
            id = 2,
            icon = "https://digitalinnovationone.github.io/santander-dev-week-2023-api/icons/insurance.svg",
            description = "Santander Seguro Casa, seu faz-tudo. Mais de 50 serviços pra você. Confira!"
        )
    )
)