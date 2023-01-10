package com.hmyh.note.view.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Hsu Myat Ye Htet on Jan 10, 2023
 */
abstract class BaseViewHolder<W>(itemView: View): RecyclerView.ViewHolder(itemView) {

    protected var mData: W?=null

    abstract fun bindData(data: W)
}