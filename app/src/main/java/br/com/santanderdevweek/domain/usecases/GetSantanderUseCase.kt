package br.com.santanderdevweek.domain.usecases

import br.com.santanderdevweek.domain.repository.SantanderRepository
import br.com.santanderdevweek.extensions.others.executeFlow

class GetSantanderUseCase(
    private val repository: SantanderRepository
) {
    suspend operator fun invoke() = executeFlow(
        getRepository = {
            repository.getSantander()
        }
    )
}