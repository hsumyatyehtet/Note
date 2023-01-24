package com.hmyh.note.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.hmyh.note.R
import com.hmyh.note.adapter.NoteItemAdapter
import com.hmyh.note.data.vos.NoteListVO
import com.hmyh.note.databinding.ActivityMainBinding
import com.hmyh.note.utils.getNoteList
import com.hmyh.note.viewmodel.NoteListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: NoteListViewModel

    private lateinit var mNoteAdapter: NoteItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //hide keyboard when launch
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)

        setUpViewModel()
        setUpRecyclerView()

        setUpDataObservation()
        setUpListener()

    }

    private fun setUpViewModel() {
        viewModel = ViewModelProviders.of(this)[NoteListViewModel::class.java]
    }

    private fun setUpDataObservation() {
        viewModel.getNoteList().observe(this, Observer {
            it?.let { noteList->
                mNoteAdapter.setNewData(noteList as MutableList<NoteListVO>)
            }
        })
    }

    private fun setUpListener() {
        //hide keyboard when launch
        binding.etNoteSearch.requestFocus()

        binding.fabAddNote.setOnClickListener {
            startActivity(NoteCreateActivity.newIntent(this))
        }
    }

    private fun setUpRecyclerView() {
        mNoteAdapter = NoteItemAdapter()
        binding.rvNoteList.layoutManager =
            StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)
        binding.rvNoteList.adapter = mNoteAdapter

     //   mNoteAdapter.setNewData(getNoteList())

        binding.rvNoteList.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                if (dy > 10 && binding.fabAddNote.isShown) {
                    binding.fabAddNote.hide()
                }

                if (dy < -10 && !binding.fabAddNote.isShown) {
                    binding.fabAddNote.show()
                }

                if (!recyclerView.canScrollVertically(-1)) {
                    binding.fabAddNote.show()
                }
            }
        })
    }

}