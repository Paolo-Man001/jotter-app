package com.paolomanlunas.jotter.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.paolomanlunas.jotter.R
import com.paolomanlunas.jotter.model.JotItem

class ItemListAdapter internal constructor(
   context: Context
) : RecyclerView.Adapter<ItemListAdapter.ItemViewHolder>() {

   private val inflater: LayoutInflater = LayoutInflater.from(context)
   private var items = emptyList<JotItem>()

   inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
      val JotTitle = itemView.findViewById<TextView>(R.id.jotTitle)
      val JotDesc = itemView.findViewById<TextView>(R.id.jotDescription)
   }

   internal fun setItems(items: List<JotItem>) {
      this.items = items
      notifyDataSetChanged()
   }

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
      val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
      return ItemViewHolder(itemView)
   }

   override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
      val current = items[position]
      holder.JotTitle.text = current.itemTitle
      holder.JotDesc.text = current.itemDesc
   }

   override fun getItemCount(): Int = items.size

}