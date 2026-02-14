package com.example.syncdbapp.di

import android.content.Context
import androidx.room.Room
import com.example.syncdbapp.data.local.AppDatabase
import com.example.syncdbapp.data.local.dao.UserActionDao
import com.example.syncdbapp.data.remote.api.UserApi
import com.example.syncdbapp.data.repository.UserActionRepositoryImpl
import com.example.syncdbapp.domain.repository.UserActionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDb(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "app_db").build()

    @Provides
    fun provideDao(db: AppDatabase): UserActionDao = db.userActionDao()

    @Provides
    @Singleton
    fun provideApi(): UserApi =
        Retrofit.Builder()
            .baseUrl("https://api.example.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserApi::class.java)

    @Provides
    @Singleton
    fun provideRepository(
        impl: UserActionRepositoryImpl
    ): UserActionRepository = impl
}
