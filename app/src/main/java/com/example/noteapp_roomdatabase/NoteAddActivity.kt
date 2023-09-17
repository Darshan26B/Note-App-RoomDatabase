package com.example.noteapp_roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.noteapp_roomdatabase.Adapter.NotesAdapter
import com.example.noteapp_roomdatabase.Database.RoomDB
import com.example.noteapp_roomdatabase.Entity.NoteEntity
import com.example.noteapp_roomdatabase.databinding.NoteAddBinding

class NoteAddActivity : AppCompatActivity() {

    lateinit var binding: NoteAddBinding
    lateinit var db:RoomDB
    lateinit var adapter: NotesAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = NoteAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {
            var title = binding.edtTitle.text.toString()
            var note = binding.edttText.text.toString()

            if (!note.equals("")) {
                 var  data = NoteEntity(title,note)
                db.note().addNote(data)

            }

            binding.edtTitle.setText("")
            binding.edttText.setText("")
            adapter.Liveupdate(db.note().fetchNote())

        }

    }
}