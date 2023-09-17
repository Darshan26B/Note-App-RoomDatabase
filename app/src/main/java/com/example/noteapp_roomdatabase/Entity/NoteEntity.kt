package com.example.noteapp_roomdatabase.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note")
data class NoteEntity(
  @ColumnInfo(name = "title") var title:String,
  @ColumnInfo(name = "text") var text:String,
) {
    @PrimaryKey(autoGenerate = true) var id:Int = 0
}

