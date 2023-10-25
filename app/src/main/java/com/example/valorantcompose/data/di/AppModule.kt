package com.example.valorantcompose.data.di

import com.example.valorantcompose.common.Constants.BASE_URL
import com.example.valorantcompose.data.remote.ServiceApi
import com.example.valorantcompose.data.remote.ServiceDataSource
import com.example.valorantcompose.data.repository.AgentsRepositoryImpl
import com.example.valorantcompose.domain.repository.AgentsRepository
import com.example.valorantcompose.domain.usecase.GetAgentsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideServiceApi(): ServiceApi {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ServiceApi::class.java)
    }

    @Singleton
    @Provides
    fun provideAgentsRepository(dataSource: ServiceDataSource) : AgentsRepository {
        return AgentsRepositoryImpl(dataSource)
    }

    @Singleton
    @Provides
    fun provideGetAgentsUseCase(repository: AgentsRepository) : GetAgentsUseCase {
        return GetAgentsUseCase(repository)
    }
}