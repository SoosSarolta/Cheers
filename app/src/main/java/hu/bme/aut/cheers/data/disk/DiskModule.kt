package hu.bme.aut.cheers.data.disk

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DiskModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(context: Context): CoctailDatabase {
        return Room.databaseBuilder(context, CoctailDatabase::class.java, "coctails.db").build()
    }

    @Provides
    @Singleton
    fun provideCoctailDao(coctailDatabase: CoctailDatabase): CoctailDao = coctailDatabase.coctailDao()
}