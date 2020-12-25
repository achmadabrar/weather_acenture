package com.achmadabrar.accenturetest.ui

import android.os.Bundle
import com.achmadabrar.accenturetest.R
import com.achmadabrar.accenturetest.core.BaseActivity
import com.achmadabrar.accenturetest.ui.fragments.HomeFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout, HomeFragment())
        transaction.commit()
    }
}