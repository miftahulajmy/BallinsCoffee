package com.example.project_irfan.database
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.project_irfan.model.ModelDatabase
import com.example.project_irfan.database.dao.DatabaseDao


@Database(entities = [ModelDatabase::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun databaseDao(): DatabaseDao?
}