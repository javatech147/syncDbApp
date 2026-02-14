package com.example.syncdbapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.syncdbapp.data.local.dao.UserActionDao
import com.example.syncdbapp.data.local.entity.UserActionEntity

@Database(entities = [UserActionEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userActionDao(): UserActionDao
}
