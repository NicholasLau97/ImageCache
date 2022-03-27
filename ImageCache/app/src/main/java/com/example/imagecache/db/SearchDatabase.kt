package com.example.imagecache.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.imagecache.models.Image
import com.example.imagecache.models.SearchImage

@Database(
    entities = [SearchImage::class,Image::class],
    version = 1
)
abstract class SearchDatabase : RoomDatabase(){
    abstract fun getImageDao(): SearchDao

    companion object {
        @Volatile
        private var instance: SearchDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                SearchDatabase::class.java,
                "search_db.db"
            ).build()
    }
    /*
    abstract fun getImageDao():SearchDao
    companion object{
        private var INSTANCE:SearchDatabase?=null
        fun getInstance(context: Context):SearchDatabase{
            synchronized(this){
                var instance = INSTANCE
                if(instance==null){
                    instance= Room.databaseBuilder(
                        context.applicationContext,
                        SearchDatabase::class.java,
                        "search_db.db"
                    ).build()
                }
                return instance
            }
        }
    }

    */
}