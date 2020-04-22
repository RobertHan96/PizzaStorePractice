package com.nexon.pizzastorepractice

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import com.nexon.pizzastorepractice.datas.Store
import kotlinx.android.synthetic.main.activity_store_detail.*

class StoreDetailActivity : BaseActivity() {
    private lateinit var storeData : Store

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_detail)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        btnCall.setOnClickListener {
            val permissionListener = object  : PermissionListener {
                override fun onPermissionGranted() {
                    val uri = Uri.parse("tel:01022345619")
                    val myIntent = Intent(Intent.ACTION_CALL, uri)
                    startActivity(myIntent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    Toast.makeText(mContext, "권한 허용 필요", Toast.LENGTH_SHORT).show()
                }

            }

            TedPermission.with(mContext).setPermissionListener(permissionListener).setDeniedMessage("설정에서 권한을 허용해주세요.")
                .setPermissions(Manifest.permission.CALL_PHONE).check()

        }
    }

    override fun setValues() {
        fetchStoreData()
    }

    fun fetchStoreData() {
        storeData = intent.getSerializableExtra("storeData") as Store
        storeName.text = storeData.Name
        storePhone.text = storeData.phone
        val storeDetailLogoImg = findViewById<ImageView>(R.id.storeDetailLogoImg)
        Glide.with(mContext).load(storeData.logoUrl).into(storeDetailLogoImg)
    }

}
