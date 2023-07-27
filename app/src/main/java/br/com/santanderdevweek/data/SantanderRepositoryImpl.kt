package br.com.santanderdevweek.data

import br.com.santanderdevweek.data.mapper.toSantander
import br.com.santanderdevweek.data.models.SantanderResponse
import br.com.santanderdevweek.domain.models.Santander
import br.com.santanderdevweek.domain.repository.SantanderRepository
import br.com.santanderdevweek.extensions.network.toResponse
import br.com.santanderdevweek.network.service.NetworkingApi

class SantanderRepositoryImpl(
    private val networkingApi: NetworkingApi
): SantanderRepository {
    override suspend fun getSantander(): Santander {
        return networkingApi.get(
            url = ACCOUNT,
            responseKClass = SantanderResponse::class
        ).toResponse().toSantander()
    }
}