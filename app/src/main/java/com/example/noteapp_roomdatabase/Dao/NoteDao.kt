package com.example.noteapp_roomdatabase.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.noteapp_roomdatabase.Entity.NoteEntity


@Dao
interface NoteDao {
    @Insert
    fun addNote(noteEntity: NoteEntity)

    @Query("SELECT * FROM note")
    fun fetchNote():List<NoteEntity>

    @Update
    fun updateNote(noteEntity: NoteEntity)

    @Delete
    fun deleteNote(noteEntity: NoteEntity)
}