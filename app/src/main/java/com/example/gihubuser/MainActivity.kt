package com.example.gihubuser

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gihubuser.adapter.UserAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var dataName: Array<String>
    private lateinit var dataUsername: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataRepository: Array<String>
    private lateinit var dataCompany: Array<String>
    private lateinit var dataFollowers: Array<String>
    private lateinit var dataFollowing: Array<String>
    private lateinit var dataPhoto: TypedArray
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
        dataName = resources.getStringArray(R.array.name)
        dataUsername = resources.getStringArray(R.array.username)
        dataLocation = resources.getStringArray(R.array.location)
        dataRepository = resources.getStringArray(R.array.repository)
        dataCompany = resources.getStringArray(R.array.company)
        dataFollowers = resources.getStringArray(R.array.followers)
        dataFollowing = resources.getStringArray(R.array.following)
        dataPhoto = resources.obtainTypedArray(R.array.avatar)
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