package hu.bme.aut.cheers.mock

import dagger.Module
import dagger.Provides
import hu.bme.aut.cheers.data.network.CoctailApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
class MockNetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    @Provides
    @Singleton
    fun provideCoctailsApi(): CoctailApi = MockCoctailApi()
}