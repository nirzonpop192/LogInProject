package com.ptsl.faisal.loginproject.home.Model

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query

@Dao
interface NoteItemDao {

    @Insert(onConflict = REPLACE)
    fun insertListItem(noteItem: NoteItem): Long

    @Delete
    fun deleteListItem(noteItem: NoteItem)

    @Query("Select * from NoteItem")
    fun getNoteList()
}