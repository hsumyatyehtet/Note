package com.hmyh.note.data.model

import com.hmyh.note.data.vos.NoteListVO

interface NoteModel {

    fun insertNote(
        noteListVO: NoteListVO
    )

}