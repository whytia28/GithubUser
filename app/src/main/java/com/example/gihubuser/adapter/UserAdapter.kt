package com.example.gihubuser.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gihubuser.R
import com.example.gihubuser.User


class UserAdapter(
    private val context: Context,
    private var listUser: List<User>,
    private var listener: (User) -> Unit
) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_user, viewGroup, false))


    override fun getItemCount(): Int = listUser.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindUser(listUser[position], listener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var tvName: TextView = itemView.findViewById(R.id.txt_name)
        private var tvUsername: TextView = itemView.findViewById(R.id.txt_username)
        private var imgPhoto: ImageView = itemView.findViewById(R.id.img_photo)

        fun bindUser(listUser: User, listener: (User) -> Unit) {
            tvName.text = listUser.name
            tvUsername.text = listUser.username
            listUser.avatar.apply { Glide.with(itemView).load(listUser.avatar).into(imgPhoto) }
            itemView.setOnClickListener { listener(listUser) }

        }
    }
}