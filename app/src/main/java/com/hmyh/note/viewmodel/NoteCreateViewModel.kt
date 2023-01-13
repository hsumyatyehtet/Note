package com.hmyh.note.viewmodel

import androidx.lifecycle.ViewModel
import com.hmyh.note.data.model.NoteModel
import com.hmyh.note.data.model.impl.NoteModelImpl
import com.hmyh.note.data.vos.NoteListVO

class NoteCreateViewModel: ViewModel() {

    private val mModel: NoteModel = NoteModelImpl

    fun insertNote(noteListVO: NoteListVO){
        mModel.insertNote(noteListVO)
    }

}