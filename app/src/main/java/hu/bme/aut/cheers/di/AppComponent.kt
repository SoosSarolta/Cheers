package hu.bme.aut.cheers.di

import co.zsmb.rainbowcake.dagger.RainbowCakeComponent
import co.zsmb.rainbowcake.dagger.RainbowCakeModule
import dagger.Component
import hu.bme.aut.cheers.data.disk.DiskModule
import hu.bme.aut.cheers.data.network.NetworkModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RainbowCakeModule::class,
        ApplicationModule::class,
        ViewModelModule::class,
        NetworkModule::class,
        DiskModule::class
    ]
)
interface AppComponent : RainbowCakeComponent