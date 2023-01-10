package com.hmyh.note.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.hmyh.note.data.vos.NoteListVO
import com.hmyh.note.databinding.ViewHolderInNoteBinding
import com.hmyh.note.view.holder.NoteItemViewHolder

class NoteItemAdapter: BaseRecyclerAdapter<NoteItemViewHolder,NoteListVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteItemViewHolder {
        return NoteItemViewHolder(
            ViewHolderInNoteBinding.inflate(
                LayoutInflater.from(parent.context),parent,false
            )
        )
    }
}