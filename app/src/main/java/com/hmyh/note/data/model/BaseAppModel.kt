package com.hmyh.note.data.model

import android.content.Context
import com.hmyh.note.persistance.NoteDatabase

abstract class BaseAppModel: BaseModel() {

    protected lateinit var mDatabase: NoteDatabase

    override fun init(context: Context) {
        initDatabase(context)
    }

    private fun initDatabase(context: Context) {
        mDatabase = NoteDatabase.getInstance(context)
    }
}