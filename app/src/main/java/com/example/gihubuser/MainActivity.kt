package com.example.gihubuser

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gihubuser.adapter.UserAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var dataName: Array<String>
    private lateinit var dataUsername: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataRepository: TypedArray
    private lateinit var dataCompany: Array<String>
    private lateinit var dataFollowers: TypedArray
    private lateinit var dataFollowing: TypedArray
    private lateinit var dataPhoto: TypedArray
    private var users: MutableList<User> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = findViewById<RecyclerView>(R.id.rv_User)
        initData()

        list.layoutManager = LinearLayoutManager(this)
        list.adapter = UserAdapter(this, users) {
            val toast = Toast.makeText(applicationContext, it.name, Toast.LENGTH_SHORT)
            toast.show()
        }
    }

    private fun initData() {
        dataName = resources.getStringArray(R.array.name)
        dataUsername = resources.getStringArray(R.array.username)
        dataLocation = resources.getStringArray(R.array.location)
        dataRepository = resources.obtainTypedArray(R.array.repository)
        dataCompany = resources.getStringArray(R.array.company)
        dataFollowers = resources.obtainTypedArray(R.array.followers)
        dataFollowing = resources.obtainTypedArray(R.array.following)
        dataPhoto = resources.obtainTypedArray(R.array.avatar)
        users.clear()
        for (i in dataName.indices) {
            users.add(
                User(
                    dataName[1],
                    dataUsername[i],
                    dataLocation[i],
                    dataRepository.getResourceId(i, 0),
                    dataCompany[i],
                    dataFollowers.getResourceId(i, 0),
                    dataFollowing.getResourceId(i, 0),
                    dataPhoto.getResourceId(i, 0)
                )
            )
        }
        dataPhoto.recycle()
    }
}