package com.hmyh.note.persistance

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hmyh.note.data.vos.NoteListVO
import com.hmyh.note.persistance.daos.NoteDao

@Database(entities = [NoteListVO::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteListDao(): NoteDao

    companion object {

        private var INSTANCE: NoteDatabase? = null

        private const val DB_NAME = "Note.db"

        fun getInstance(context: Context): NoteDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                NoteDatabase::class.java, DB_NAME
            )
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()

    }

}