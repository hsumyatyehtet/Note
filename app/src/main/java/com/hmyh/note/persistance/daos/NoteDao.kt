package com.hmyh.note.persistance.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hmyh.note.data.vos.NoteListVO
import io.reactivex.Completable

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(noteListVO: NoteListVO): Completable

    @Query("select * from note_list")
    fun retrieveNoteList(): LiveData<List<NoteListVO>>

}