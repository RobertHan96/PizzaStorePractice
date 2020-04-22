package com.nexon.pizzastorepractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nexon.pizzastorepractice.datas.Store

class StoreDetailActivity : BaseActivity() {
    private lateinit var storeData : Store

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_detail)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
    }

    override fun setValues() {
        storeData = intent.getSerializableExtra("storeData") as Store

    }

}
