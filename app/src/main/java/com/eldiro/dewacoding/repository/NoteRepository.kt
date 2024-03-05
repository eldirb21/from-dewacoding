package com.eldiro.dewacoding.repository

import com.eldiro.dewacoding.data.dao.NoteDao
import com.eldiro.dewacoding.data.model.Note
import javax.inject.Inject

class NoteRepository @Inject constructor(
    val noteDao: NoteDao
) {
    fun getAll() = noteDao.getAll()

    suspend fun insert(note: Note) = noteDao.insert(note)

    suspend fun delete(note: Note) = noteDao.delete(note)
}