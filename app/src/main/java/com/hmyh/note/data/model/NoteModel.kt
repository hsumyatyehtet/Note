package com.hmyh.note.data.model

import androidx.lifecycle.LiveData
import com.hmyh.note.data.vos.NoteListVO

interface NoteModel {

    fun insertNote(noteListVO: NoteListVO)

    fun getNoteList(): LiveData<List<NoteListVO>>

}