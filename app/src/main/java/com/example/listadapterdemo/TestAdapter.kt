package com.example.listadapterdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.listadapterdemo.databinding.ItemTestBinding

/**
 * Created by Sajid.
 */

class TestAdapter : ListAdapter<Person, TestAdapter.TestViewHolder>(MyDiffUtil()) {


    class TestViewHolder(var binding: ItemTestBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
        return TestViewHolder(
            ItemTestBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        holder.binding.data = getItem(position)
    }


    class MyDiffUtil :
        DiffUtil.ItemCallback<Person>() {

        override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
            return oldItem == newItem
        }
    }
}