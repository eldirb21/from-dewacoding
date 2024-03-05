package com.eldiro.dewacoding.ui.addnote

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.eldiro.dewacoding.data.model.Note
import com.eldiro.dewacoding.databinding.ActivityCreateBinding
import com.eldiro.dewacoding.viewmodel.NoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddNoteActivity: AppCompatActivity() {

    private val binding by lazy { ActivityCreateBinding.inflate(layoutInflater) }
    private val noteViewModel: NoteViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.imgCheck.setOnClickListener {
            if (!binding.etTitle.text.toString().isNullOrEmpty()
                && !binding.etDescription.text.toString().isNullOrEmpty()) {
                noteViewModel.insert(Note(null, binding.etTitle.text.toString(), binding.etDescription.text.toString()))
            } else {
                Toast.makeText(applicationContext, "Ada data yang masih kosong", Toast.LENGTH_SHORT).show()
            }
            finish()
        }
    }
}