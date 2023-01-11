package com.hmyh.note.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
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

        setUpRecyclerView()

    }

    private fun setUpRecyclerView() {
        mNoteAdapter = NoteItemAdapter()
        binding.rvNoteList.layoutManager =
            GridLayoutManager(this,2)
        binding.rvNoteList.adapter = mNoteAdapter

        mNoteAdapter.setNewData(getNoteList())

        binding.rvNoteList.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                if (dy > 10 && binding.fabAddNote.isShown) {
                    binding.fabAddNote.hide()
                }

                // if the recycler view is scrolled
                // above extend the FAB
                if (dy < -10 && !binding.fabAddNote.isShown) {
                    binding.fabAddNote.show()
                }

                // of the recycler view is at the first
                // item always extend the FAB
                if (!recyclerView.canScrollVertically(-1)) {
                    binding.fabAddNote.show()
                }
            }
        })
    }

}