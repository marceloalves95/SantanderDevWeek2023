package br.com.santanderdevweek.domain.repository

import br.com.santanderdevweek.data.models.SantanderResponse
import br.com.santanderdevweek.domain.models.Account
import br.com.santanderdevweek.domain.models.Santander

interface SantanderRepository {
    suspend fun getSantander(): Santander
}