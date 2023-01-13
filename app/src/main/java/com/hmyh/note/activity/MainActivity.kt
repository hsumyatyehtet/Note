package com.hmyh.note.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.hmyh.note.R
import com.hmyh.note.adapter.NoteItemAdapter
import com.hmyh.note.databinding.ActivityMainBinding
import com.hmyh.note.utils.getNoteList
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var mNoteAdapter: NoteItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //hide keyboard when launch
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        setUpRecyclerView()
        setUpListener()

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

        mNoteAdapter.setNewData(getNoteList())

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