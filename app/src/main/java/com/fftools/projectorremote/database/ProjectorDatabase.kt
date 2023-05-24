package com.fftools.projectorremote.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fftools.projectorremote.database.dao.ProjectorDao
import com.fftools.projectorremote.model.ProjectorBrandEntity

@Database(
    entities = [ProjectorBrandEntity::class],
    version = 1
)
abstract class ProjectorDatabase : RoomDatabase() {

    abstract fun getProjectorDao(): ProjectorDao

    companion object {
        @Volatile
        private var instance: ProjectorDatabase? = null

        fun getInstance(context: Context): ProjectorDatabase {
            if (instance == null) {
                instance =
                    Room.databaseBuilder(context, ProjectorDatabase::class.java, "projector.db")
                        .createFromAsset("projector.db").build()
            }
            return instance!!
        }
    }
}