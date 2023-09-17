package com.example.noteapp_roomdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteapp_roomdatabase.Adapter.NotesAdapter
import com.example.noteapp_roomdatabase.Database.RoomDB
import com.example.noteapp_roomdatabase.Entity.NoteEntity
import com.example.noteapp_roomdatabase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var db:RoomDB
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: NotesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = RoomDB.DB_Name(this)
        db.note().fetchNote()

        binding.add.setOnClickListener {
            var Intent = Intent(this,NoteAddActivity::class.java)
            startActivity(Intent)
        }

         adapter.setNote(db.note().fetchNote())
        binding.noteListrcv.layoutManager = LinearLayoutManager(this)
        binding.noteListrcv.adapter =adapter
    }
}