package com.eldiro.dewacoding.data


import androidx.room.Database
import androidx.room.RoomDatabase
import com.eldiro.dewacoding.data.dao.NoteDao
import com.eldiro.dewacoding.data.model.Note

@Database(entities = [Note::class], version = 2)
abstract class AppDatabase: RoomDatabase() {
    abstract fun noteDao(): NoteDao
}