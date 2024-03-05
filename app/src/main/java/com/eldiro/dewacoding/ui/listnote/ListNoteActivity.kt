package com.eldiro.dewacoding.ui.listnote

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.eldiro.dewacoding.data.model.Note
import com.eldiro.dewacoding.databinding.ActivityMainBinding
import com.eldiro.dewacoding.listener.OnNoteClickListener
import com.eldiro.dewacoding.ui.addnote.AddNoteActivity
import com.eldiro.dewacoding.viewmodel.NoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListNoteActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}
    lateinit var adapter: ListNoteAdapter
    private val noteViewModel: NoteViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        adapter = ListNoteAdapter(applicationContext, object: OnNoteClickListener {
            override fun onDelete(note: Note) {
                noteViewModel.delete(note)
            }

        })
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = StaggeredGridLayoutManager(2, LinearLayout.VERTICAL)
        binding.recyclerView.adapter = adapter

        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(applicationContext, AddNoteActivity::class.java)
            startActivity(intent)
        }

        noteViewModel.getAll().observe(this) { list ->
            list.let {
                adapter.updateList(list)
            }
        }
    }
}