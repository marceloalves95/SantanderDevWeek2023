package br.com.santanderdevweek.core.di

import br.com.santanderdevweek.data.SantanderRepositoryImpl
import br.com.santanderdevweek.domain.repository.SantanderRepository
import br.com.santanderdevweek.domain.usecases.GetSantanderUseCase
import br.com.santanderdevweek.presentation.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.GlobalContext.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

object SantanderDevWeekModule {

    fun load() {
        loadKoinModules(
            listOf(
                dataModule(),
                domainModule(),
                presentationModule()
            )
        )
    }

    private fun dataModule(): Module = module {
        single<SantanderRepository> {
            SantanderRepositoryImpl(get())
        }
    }

    private fun domainModule(): Module = module {
        factory { GetSantanderUseCase(get()) }
    }

    private fun presentationModule(): Module = module {
        viewModel {
            MainViewModel(
                getSantanderUseCase = get()
            )
        }
    }

}