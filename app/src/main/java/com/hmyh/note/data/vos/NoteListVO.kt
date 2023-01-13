package com.hmyh.note.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_list")
data class NoteListVO(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var noteId: Long = 0,

    @ColumnInfo(name = "note_title")
    var noteTitle: String?=null,

    @ColumnInfo(name = "note_desc")
    var noteDesc: String?=null,

    @ColumnInfo(name = "note_date")
    var noteDate: String?=null

)