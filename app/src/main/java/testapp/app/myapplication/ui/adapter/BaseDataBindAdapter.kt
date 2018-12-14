package testapp.app.myapplication.ui.adapter

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import android.support.annotation.NonNull
import android.support.annotation.Nullable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import testapp.app.myapplication.BR

class BaseDataBindAdapter <T>(@LayoutRes private var layoutId: Int,
                                       private var variableId: Int,
                                       @Nullable dataList: List<T>?,
                                       private var onClickAdapter: OnClickAdapterDataBinding? = null) :
            RecyclerView.Adapter<BaseDataBindAdapter.BindingHolder>() {

        var dataList: List<T> = dataList ?: mutableListOf()
            set(value) {
                field = value
                notifyDataSetChanged()
            }

        override fun getItemCount(): Int = dataList.size

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder {
            val v = LayoutInflater.from(parent.context)
                    .inflate(layoutId, parent, false)
            return BindingHolder(v)
        }

        override fun onBindViewHolder(holder: BindingHolder, position: Int) {
            holder.binding?.setVariable(variableId, getItem(position))
            holder.binding?.setVariable(BR.handler, onClickAdapter)
        }

        override fun getItemId(position: Int): Long = position.toLong()

        fun getItem(position: Int): T = dataList[position]

        class BindingHolder(v: View) : RecyclerView.ViewHolder(v) {
            val binding: ViewDataBinding? = DataBindingUtil.bind(v)
        }

    interface OnClickAdapterDataBinding

}