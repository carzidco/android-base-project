package com.base.application.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView

class BoundRecyclerAdapter<T>(
    private val viewModel: ViewModel,
    private val layoutResolver: (T) -> Int
) : RecyclerView.Adapter<BoundRecyclerAdapter<T>.BoundViewHolder>() {
    var data: List<T> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoundViewHolder {
        return BoundViewHolder(LayoutInflater.from(parent.context).inflate(viewType, parent, false))
    }

    override fun onBindViewHolder(holder: BoundViewHolder, position: Int) {
        holder.binding.also {
            //it.setVariable(BR.entity, data[position])
            //it.setVariable(BR.vm, viewModel)
        }.executePendingBindings()
    }

    override fun getItemCount(): Int = data.size

    override fun getItemViewType(position: Int): Int = layoutResolver(data[position])

    inner class BoundViewHolder(root: View) : RecyclerView.ViewHolder(root) {
        val binding: ViewDataBinding = DataBindingUtil.bind(root)!!
    }
}