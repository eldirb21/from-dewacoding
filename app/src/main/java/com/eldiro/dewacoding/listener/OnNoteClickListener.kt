package com.eldiro.dewacoding.listener

import com.eldiro.dewacoding.data.model.Note

interface OnNoteClickListener {
    fun onDelete(note: Note)
}