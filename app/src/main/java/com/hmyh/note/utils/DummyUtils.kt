package com.hmyh.note.utils

import com.hmyh.note.data.vos.NoteListVO

fun getNoteList(): MutableList<NoteListVO>{
    return mutableListOf(
        NoteListVO(1,"Note 1","Why and how to use suspending functions to perform network requests."),
        NoteListVO(2,"ABC 2","How to send requests concurrently using coroutines"),
        NoteListVO(3,"Developer","Copy the generated token"),
        NoteListVO(4,"Love is Pain","Testing by hmyh"),
        NoteListVO(5,"Crush","Hello Hi"),
        NoteListVO(6,"Coroutines","There are different ways of implementing this logic: by using blocking requests or callbacks."),
        NoteListVO(7,"From my crush hee","Blocking requests")
    )
}