package com.hmyh.note.utils

import com.hmyh.note.data.vos.NoteListVO

fun getNoteList(): MutableList<NoteListVO>{
    return mutableListOf(
        NoteListVO(1,"1"),
        NoteListVO(2,"2"),
        NoteListVO(3,"3"),
        NoteListVO(4,"4"),
        NoteListVO(5,"5")
    )
}