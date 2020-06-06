package com.example.gihubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_USER = "EXTRA_USER"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.setTitle("User Detail")
        val user = intent.getParcelableExtra(EXTRA_USER) as User
        avatar.setImageResource(user.avatar)
        name.text = user.username
        username.text = user.name
        location.text = user.location
        company.text = user.company
        repository.text = user.repository.toString()
        followers.text = user.followers.toString()
        following.text = user.following.toString()
    }
}