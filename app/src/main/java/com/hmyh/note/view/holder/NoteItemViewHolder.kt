package com.hmyh.note.view.holder

import com.hmyh.note.data.vos.NoteListVO
import com.hmyh.note.databinding.ViewHolderInNoteBinding

class NoteItemViewHolder(private val binding: ViewHolderInNoteBinding)
    :BaseViewHolder<NoteListVO>(binding.root){

    override fun bindData(data: NoteListVO) {
        binding.tvNoteTitleItem.text = data.noteTitle ?: ""
        binding.tvNoteItem.text = data.noteDesc ?: ""
    }
}