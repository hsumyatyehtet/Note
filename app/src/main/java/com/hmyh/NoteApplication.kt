package com.hmyh

import android.app.Application
import android.content.Context
import com.hmyh.note.data.model.impl.NoteModelImpl

/**
 * Created by Hsu Myat Ye Htet on Jan 12, 2023
 */
class NoteApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        application = applicationContext

        NoteModelImpl.init(applicationContext)
    }

    companion object{
        lateinit var application: Context
    }

}