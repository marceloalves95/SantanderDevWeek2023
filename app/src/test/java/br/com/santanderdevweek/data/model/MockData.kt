package br.com.santanderdevweek.data.model

import br.com.santanderdevweek.data.models.AccountResponse
import br.com.santanderdevweek.data.models.CardResponse
import br.com.santanderdevweek.data.models.FeatureResponse
import br.com.santanderdevweek.data.models.NewsResponse
import br.com.santanderdevweek.data.models.SantanderResponse

val dummyAccountResponse = AccountResponse(
    id = 1,
    number = "01.097954-4",
    agency = "2030",
    balance = 624.12,
    limit = 1000.00
)

val dummyCardResponse = CardResponse(
    id = 1,
    number = "xxxx xxxx xxxx 1111",
    limit = 2000.00
)

val dummyFeatureResponse = FeatureResponse(
    id = 1,
    icon = "https://digitalinnovationone.github.io/santander-dev-week-2023-api/icons/pix.svg",
    description = "PIX"
)

val dummyNewsResponse = NewsResponse(
    id = 1,
    icon = "https://digitalinnovationone.github.io/santander-dev-week-2023-api/icons/credit.svg",
    description = "O Santander tem soluções de crédito sob medida pra você. Confira!"
)

val dummySantanderResponse = SantanderResponse(
    id = 1,
    name = "Devweekerson",
    account = dummyAccountResponse,
    card = dummyCardResponse,
    features = listOf(
        dummyFeatureResponse,
        dummyFeatureResponse.copy(
            id = 2,
            icon = "https://digitalinnovationone.github.io/santander-dev-week-2023-api/icons/pay.svg",
            description = "Pagar"
        ),
        dummyFeatureResponse.copy(
            id = 3,
            icon = "https://digitalinnovationone.github.io/santander-dev-week-2023-api/icons/transfer.svg",
            description = "Transferir"
        ),
        dummyFeatureResponse.copy(
            id = 4,
            icon = "https://digitalinnovationone.github.io/santander-dev-week-2023-api/icons/account.svg",
            description = "Conta Corrente"
        ),
        dummyFeatureResponse.copy(
            id = 5,
            icon = "https://digitalinnovationone.github.io/santander-dev-week-2023-api/icons/cards.svg",
            description = "Cartões"
        )
    ),
    news = listOf(
        dummyNewsResponse,
        dummyNewsResponse.copy(
            id = 2,
            icon = "https://digitalinnovationone.github.io/santander-dev-week-2023-api/icons/insurance.svg",
            description = "Santander Seguro Casa, seu faz-tudo. Mais de 50 serviços pra você. Confira!"
        )
    )
)