package com.ptsl.faisal.loginproject.home.Model

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

/**
 * we need a DatabaseClass, annotated with Database.
 * The Database class establishes a logical grouping between the DAO interfaces.
 * It also defines the required version number, which is used to track and implement database migrations.
 */
@Database(entities = arrayOf(NoteItem::class), version = 1)
abstract class NoteItemDataBase : RoomDatabase() {

    abstract fun noteItemDataDao(): NoteItemDao

    companion object {
        private var INSTANCE: NoteItemDataBase? = null

        fun getInstance(context: Context): NoteItemDataBase? {
            synchronized(NoteItemDataBase::class){
                INSTANCE= Room.databaseBuilder(context.applicationContext,
                        NoteItemDataBase::class.java,"note.db")
                        .build()
            }

            return INSTANCE
        }

        fun destroyInstance(){
            INSTANCE=null
        }
    }
}