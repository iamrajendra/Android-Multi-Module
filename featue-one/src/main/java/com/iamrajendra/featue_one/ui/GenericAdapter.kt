package com.iamrajendra.featue_one.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iamrajendra.base.pojo.Post
import com.iamrajendra.featue_one.databinding.ItemListBinding

class GenericAdapter(list: List<Any> = listOf(), type: Int = POST) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        val POST = 1
    }

    var list = list
    val type = type

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (type == POST) {
            val binding =
                ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return PostViewHoler(binding)
        }
        return Pass(null)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (type == POST) {
            var post = holder as PostViewHoler
            var postData = list[position] as Post
            post.bind(postData)
        }
    }

    override fun getItemCount(): Int {

        return list.size
    }
fun update(list: List<Any>){
    this.list = list
    notifyDataSetChanged()
}

    class PostViewHoler(itemListBinding: ItemListBinding) :
        RecyclerView.ViewHolder(itemListBinding.root) {

        var itemListBinding = itemListBinding;
        fun bind(postData: Post) {
            itemListBinding.item.text = postData.title
        }

    }

    class Pass(itemListBinding: ItemListBinding?) : RecyclerView.ViewHolder(itemListBinding!!?.root)

}

