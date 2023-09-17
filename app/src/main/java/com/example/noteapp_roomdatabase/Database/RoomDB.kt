package com.example.noteapp_roomdatabase.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.noteapp_roomdatabase.Dao.NoteDao
import com.example.noteapp_roomdatabase.Entity.NoteEntity

@Database(entities = [NoteEntity::class], version = 2)
abstract class RoomDB:RoomDatabase() {


    companion object {

        fun DB_Name(context: Context): RoomDB {

            var DB = Room.databaseBuilder(context, RoomDB::class.java, "Note.DB")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()

            return DB
        }

    }
    abstract fun note() : NoteDao

}