package com.codingblocks.networking

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_github.view.image
import kotlinx.android.synthetic.main.item_github.view.name

class GithubAdapter(private val context: Context, private val arrayList: ArrayList<GithubUser>) :
    RecyclerView.Adapter<GithubViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubViewHolder {
        val inflater = LayoutInflater.from(context)
        return GithubViewHolder(inflater.inflate(R.layout.item_github, parent, false))
    }

    override fun getItemCount(): Int = arrayList.size

    override fun onBindViewHolder(holder: GithubViewHolder, position: Int) {
        val user = arrayList[position]
        holder.bind(user)
    }
}

class GithubViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(user: GithubUser) {
        with(itemView) {
            name.text = user.username
            Picasso.get().load(user.avatar_url).into(image)
        }
    }
}