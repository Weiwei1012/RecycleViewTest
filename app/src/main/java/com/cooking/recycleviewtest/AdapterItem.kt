package com.cooking.recycleviewtest

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.cooking.recycleviewtest.databinding.RowItemBinding


class AdapterItem(
    private var context: Context,
    private var itemList: ArrayList<ModelItem>
):RecyclerView.Adapter<AdapterItem.HolderItem>() {

    private lateinit var binding: RowItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderItem {
        binding = RowItemBinding.inflate(LayoutInflater.from(context),parent,false)

        return HolderItem(binding.root)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: HolderItem, position: Int) {
        val model = itemList[position]

        val title = model.title
        val description = model.desciption
        val image = model.image

        holder.titleTv.text = title
        holder.descriptionTv.text = description
        holder.iconTv.setImageResource(image)

        holder.itemView.setOnClickListener{
            //Toast.makeText(context,"$title", Toast.LENGTH_SHORT).show()

            val intent = Intent(context, DetailsActivity::class.java)

            intent.putExtra("items", itemList)
            intent.putExtra("position", position)
            context.startActivity(intent)

        }
    }

    inner class HolderItem(itemView: View) : RecyclerView.ViewHolder(itemView){


        var titleTv: TextView
        var descriptionTv: TextView
        var iconTv: ImageView

        init {
            binding = RowItemBinding.bind(itemView)

            titleTv = binding.titleTv
            descriptionTv = binding.descriptionTv
            iconTv = binding.iconTv
        }
    }


}