package com.example.assignmentandroid

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView

class AdapterDataClass(val context: Context, private val data_item: ArrayList<DataModel>) : RecyclerView.Adapter<AdapterDataClass.SubItemsViewHolder>() {
    // create new views

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SubItemsViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_data, parent, false)

        return SubItemsViewHolder(view)
    }

    // binds the list items to a view
    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetTextI18n", "SimpleDateFormat")
    override fun onBindViewHolder(holder: SubItemsViewHolder, position: Int)
    {
        val subItems = data_item[position]

        holder.dataVal.text = subItems.dataStr

    }


    // return the number of the items in the list
    override fun getItemCount(): Int
    {
        return data_item.size
    }

    // Holds the views for adding it to image and text
    class SubItemsViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView)
    {
        val dataVal        : TextView = itemView.findViewById(R.id.data_item)
    }
}


