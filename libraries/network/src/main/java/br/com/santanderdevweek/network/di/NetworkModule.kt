package br.com.santanderdevweek.network.di

import br.com.santanderdevweek.network.retrofit.NAMED_RETROFIT
import br.com.santanderdevweek.network.retrofit.buildRetrofit
import br.com.santanderdevweek.network.service.NetworkingApi
import br.com.santanderdevweek.network.service.RequestMethodService
import br.com.santanderdevweek.network.service.ServiceEngine
import org.koin.core.context.loadKoinModules
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

object NetworkModule {
    fun load(baseUrl: String) {
        loadKoinModules(
            module = module {
                single(named(NAMED_RETROFIT)) {
                    buildRetrofit(baseUrl = baseUrl)
                }
                factory {
                    get<Retrofit>(named(NAMED_RETROFIT)).create(RequestMethodService::class.java)
                }
                factory<NetworkingApi> {
                    ServiceEngine(get())
                }
            })
    }
}