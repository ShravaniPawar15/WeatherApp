package com.example.weatherapp.repository

import com.example.weatherapp.data.WeatherDao
import com.example.weatherapp.model.Favourite
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import com.example.weatherapp.model.Unit

class WeatherDbRepository @Inject constructor(private val weatherDao: WeatherDao){

    fun getFavourites():Flow<List<Favourite>> = weatherDao.getFavourites()
    suspend fun insertFavourite(favourite: Favourite)=weatherDao.insertFavourite(favourite = favourite)
    suspend fun updateFavourite(favourite: Favourite)=weatherDao.updateFavourite(favourite = favourite)
    suspend fun deleteFavourites()=weatherDao.deleteAllFavourites()
    suspend fun deleteFavourite(favourite: Favourite)=weatherDao.deleteFavourite(favourite = favourite)
    suspend fun getFavById(city: String):Favourite=weatherDao.getFavById(city)


    suspend fun getUnits(): Flow<List<Unit>> = weatherDao.getUnits()
    suspend fun insertUnit(unit:Unit)=weatherDao.insertUnit(unit)
    suspend fun updateUnit(unit:Unit)=weatherDao.updateUnit(unit)
    suspend fun deleteAllUnits()=weatherDao.deleteAllUnits()
    suspend fun deleteUnit(unit:Unit)=weatherDao.deleteUnit(unit)



}