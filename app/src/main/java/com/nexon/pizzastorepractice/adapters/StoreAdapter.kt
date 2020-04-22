package com.nexon.pizzastorepractice.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.nexon.pizzastorepractice.R
import com.nexon.pizzastorepractice.datas.Store
import com.bumptech.glide.Glide

import org.w3c.dom.Text
class StoreAdapter (context : Context, resID:Int, list:ArrayList<Store>)  : ArrayAdapter<Store>(context, resID, list)  {
    val mContext = context
    val mList = list
    val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        tempRow.let {

        }.let {
            tempRow = inf.inflate(R.layout.store_list_item, null)
        }

        val row = tempRow!!
        val data = mList.get(position)

        val storeName = row.findViewById<TextView>(R.id.storeNameText)
        val storeLogoImg = row.findViewById<ImageView>(R.id.storeLogoImg)

        storeName.text = data.Name
        Glide.with(mContext).load(data.logoUrl).into(storeLogoImg)

        return  row

    }

}