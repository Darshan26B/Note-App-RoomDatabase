package com.example.noteapp_roomdatabase.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.noteapp_roomdatabase.Entity.NoteEntity
import com.example.noteapp_roomdatabase.databinding.NotercvBinding

class NotesAdapter:Adapter<NotesAdapter.NotesHolder>() {

    lateinit var context: Context
    var Notes = ArrayList<NoteEntity>()

    class NotesHolder(itemView: NotercvBinding) : ViewHolder(itemView.root) {

        var binding = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesHolder {
        context=parent.context
        var Data = NotercvBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NotesHolder(Data)
    }

    override fun getItemCount(): Int {
        return Notes.size
    }

    override fun onBindViewHolder(holder: NotesHolder, position: Int) {
        holder.binding.apply {
            txtTitle.isSelected =true
            Notes.get(position).apply {
                txtTitle.text = title
                txtText.text = text
            }
        }
    }

    fun Liveupdate(fetchNote: List<NoteEntity>) {
       this.Notes = fetchNote as ArrayList<NoteEntity>
        notifyDataSetChanged()

    }

    fun setNote(noteList: List<NoteEntity>) {
        this.Notes = noteList as ArrayList<NoteEntity>

    }
}