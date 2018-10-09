package com.ptsl.faisal.loginproject.home.Model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "NoteItem")
data class NoteItem(@PrimaryKey(autoGenerate = true) var id: Long?
                    , @ColumnInfo(name = "noteId") var noteId: String
                    , @ColumnInfo(name = "noteBody") var noteBody: String
                    , @ColumnInfo(name = "createDate") var createDate: String) {

    constructor() : this(null, "", "", "")
}