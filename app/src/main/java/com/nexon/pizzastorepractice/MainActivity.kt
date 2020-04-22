package com.nexon.pizzastorepractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nexon.pizzastorepractice.datas.Store

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()

    }

    override fun setupEvents() {
    }

    override fun setValues() {
        val tempStore = Store("피자헛", "www.naver.com", "01024369626")

    }


}
