package com.hmyh.note.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.hmyh.note.data.vos.NoteListVO
import com.hmyh.note.databinding.ActivityNoteCreateBinding
import com.hmyh.note.viewmodel.NoteCreateViewModel
import kotlinx.android.synthetic.main.activity_note_create.*

class NoteCreateActivity: BaseActivity() {

    private lateinit var binding: ActivityNoteCreateBinding
    private lateinit var viewModel: NoteCreateViewModel

    companion object{
        fun newIntent(context: Context): Intent{
            return Intent(context,NoteCreateActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNoteCreateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpViewModel()
        setUpListener()

    }

    private fun setUpViewModel() {
        viewModel = ViewModelProviders.of(this)[NoteCreateViewModel::class.java]
    }

    private fun setUpListener() {
        rlBack.setOnClickListener {
            finish()
        }

        rlDone.setOnClickListener {

            var note = binding.etNote.text.toString()

            var noteListVO = NoteListVO(0,note)

            viewModel.insertNote(noteListVO)

        }
    }

}