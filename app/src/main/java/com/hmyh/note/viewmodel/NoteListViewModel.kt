package com.hmyh.note.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hmyh.note.data.model.NoteModel
import com.hmyh.note.data.model.impl.NoteModelImpl
import com.hmyh.note.data.vos.NoteListVO

class NoteListViewModel: ViewModel() {

    private val mModel: NoteModel = NoteModelImpl

    fun getNoteList(): LiveData<List<NoteListVO>>{
        return mModel.getNoteList()
    }

}