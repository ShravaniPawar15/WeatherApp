package com.example.weatherapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.weatherapp.model.City
import com.example.weatherapp.model.Favourite
import kotlinx.coroutines.flow.Flow
import com.example.weatherapp.model.Unit

@Dao
interface WeatherDao {
    @Query(value = "SELECT * from fav_tbl")
    fun getFavourites(): Flow<List<Favourite>>

    @Query(value = "SELECT * from fav_tbl where city=:city")
    suspend fun getFavById(city: String): Favourite

    @Insert(onConflict =OnConflictStrategy.REPLACE )
    suspend fun insertFavourite(favourite: Favourite)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateFavourite(favourite: Favourite)

    @Query(value = "DELETE from fav_tbl")
    suspend fun deleteAllFavourites()

    @Delete
    suspend fun deleteFavourite(favourite: Favourite)

    //Unit
    @Query(value = "SELECT * from setting_tbl")
    fun getUnits(): Flow<List<Unit>>


    @Insert(onConflict =OnConflictStrategy.REPLACE )
    suspend fun insertUnit(unit: Unit)

    @Update(onConflict =OnConflictStrategy.REPLACE )
    suspend fun updateUnit(unit: Unit )

    @Query("DELETE from setting_tbl")
    suspend fun deleteAllUnits()

    @Delete
    suspend fun deleteUnit(unit:Unit)
}
