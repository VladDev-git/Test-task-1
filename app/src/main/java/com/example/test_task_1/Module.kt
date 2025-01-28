package com.example.test_task_1

import android.app.Application
import androidx.room.Room
import com.example.test_task_1.db.Dao
import com.example.test_task_1.db.MainDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Provides
    @Singleton
    fun provideDao(mainDb: MainDb): Dao {
        return mainDb.dao
    }

    @Provides
    @Singleton
    fun provideMainDb(app: Application): MainDb {
        return Room.databaseBuilder(
            app,
            MainDb::class.java,
            "main_db"
        ).build(
        )
    }
}