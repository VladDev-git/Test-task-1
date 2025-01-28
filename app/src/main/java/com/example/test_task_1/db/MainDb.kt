package com.example.test_task_1.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Transaction::class, Goal::class], version = 1)
abstract class MainDb : RoomDatabase() {
    abstract val dao: Dao
}