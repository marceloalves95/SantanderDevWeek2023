package br.com.santanderdevweek.core

import android.app.Application
import br.com.santanderdevweek.core.di.SantanderDevWeekModule
import br.com.santanderdevweek.data.BASE_URL
import br.com.santanderdevweek.network.di.NetworkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@Application)
        }
        SantanderDevWeekModule.load()
        NetworkModule.load(baseUrl = BASE_URL)
    }
}