package com.nexon.pizzastorepractice

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    abstract fun setupEvents()
    abstract fun setValues()
}