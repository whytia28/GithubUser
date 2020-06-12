package com.example.gihubuser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gihubuser.adapter.UserAdapter

class MainActivity : AppCompatActivity() {
    private var users: MutableList<User> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "List Github User"
        val list = findViewById<RecyclerView>(R.id.rv_User)
        initData()

        list.layoutManager = LinearLayoutManager(this)
        list.adapter = UserAdapter(this, users) {
            Intent(this@MainActivity, DetailActivity::class.java)
                .apply { putExtra(DetailActivity.EXTRA_USER, it) }.also { startActivity(it) }
        }

    }

    private fun initData() {
        val dataName = resources.getStringArray(R.array.name)
        val dataUsername = resources.getStringArray(R.array.username)
        val dataLocation = resources.getStringArray(R.array.location)
        val dataRepository = resources.getStringArray(R.array.repository)
        val dataCompany = resources.getStringArray(R.array.company)
        val dataFollowers = resources.getStringArray(R.array.followers)
        val dataFollowing = resources.getStringArray(R.array.following)
        val dataPhoto = resources.obtainTypedArray(R.array.avatar)
        users.clear()
        for (i in dataName.indices) {
            users.add(
                User(
                    dataName[i],
                    dataUsername[i],
                    dataLocation[i],
                    dataRepository[i].toInt(),
                    dataCompany[i],
                    dataFollowers[i].toInt(),
                    dataFollowing[i].toInt(),
                    dataPhoto.getResourceId(i, 0)
                )
            )
        }
        dataPhoto.recycle()
    }
}