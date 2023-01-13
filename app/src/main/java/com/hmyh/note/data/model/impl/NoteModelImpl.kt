package com.hmyh.note.data.model.impl

import com.hmyh.note.data.model.BaseAppModel
import com.hmyh.note.data.model.NoteModel
import com.hmyh.note.data.vos.NoteListVO
import com.hmyh.note.utils.subscribeDBWithCompletable

object NoteModelImpl: BaseAppModel(),NoteModel {


    override fun insertNote(noteListVO: NoteListVO) {
        mDatabase.noteListDao().insertNote(noteListVO).subscribeDBWithCompletable()
    }

}