package com.hmyh.note.persistance.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.hmyh.note.data.vos.NoteListVO
import io.reactivex.Completable

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(noteListVO: NoteListVO): Completable

}