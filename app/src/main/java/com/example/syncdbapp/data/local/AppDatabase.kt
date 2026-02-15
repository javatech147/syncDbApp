package com.example.syncdbapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.impl.Migration_1_2
import com.example.syncdbapp.data.local.dao.UserActionDao
import com.example.syncdbapp.data.local.entity.UserActionEntity

@Database(entities = [UserActionEntity::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userActionDao(): UserActionDao

    /*

    // Create singleton instance of Database if not going to user DI framework.
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE user_actions ADD COLUMN createdAt LONG NOT NULL DEFAULT(1)")
            }
        }

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context = context.applicationContext,
                    klass = AppDatabase::class.java,
                    name = "sync_db"
                )
                    .addMigrations(MIGRATION_1_2)
                    .build().also {
                    INSTANCE = it
                }
            }
        }
    }

     */
}
