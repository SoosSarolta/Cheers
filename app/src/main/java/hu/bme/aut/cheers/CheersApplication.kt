package hu.bme.aut.cheers

import co.zsmb.rainbowcake.BuildConfig
import co.zsmb.rainbowcake.config.Loggers
import co.zsmb.rainbowcake.config.rainbowCake
import co.zsmb.rainbowcake.dagger.RainbowCakeApplication
import co.zsmb.rainbowcake.timber.TIMBER
import hu.bme.aut.cheers.di.AppComponent
import hu.bme.aut.cheers.di.ApplicationModule
import hu.bme.aut.cheers.di.DaggerAppComponent
import timber.log.Timber

class CheersApplication : RainbowCakeApplication() {

    override lateinit var injector: AppComponent

    override fun setupInjector() {
        injector = DaggerAppComponent.create()
    }

    override fun onCreate() {
        super.onCreate()

        rainbowCake {
            logger = Loggers.TIMBER
            isDebug = BuildConfig.DEBUG
        }

        Timber.plant(Timber.DebugTree())
    }
}