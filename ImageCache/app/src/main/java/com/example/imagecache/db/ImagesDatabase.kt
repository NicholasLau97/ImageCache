package com.example.imagecache.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.imagecache.models.Value

@Database(
    entities = [Value::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class ImagesDatabase:RoomDatabase() {
    abstract fun getImagesDao(): ImagesDao

    companion object {
        @Volatile
        private var instance: ImagesDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ImagesDatabase::class.java,
                "images_db.db"
            ).build()
    }
}