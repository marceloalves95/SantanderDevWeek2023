package br.com.santanderdevweek.data.api

import br.com.santanderdevweek.data.models.SantanderResponse
import retrofit2.http.GET

interface SantanderDevWeekApi {
    @GET("/santander-dev-week-2023-api/mocks/find_one.json")
    suspend fun getAccount(): SantanderResponse
}