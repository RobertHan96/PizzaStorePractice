package com.nexon.pizzastorepractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nexon.pizzastorepractice.adapters.StoreAdapter
import com.nexon.pizzastorepractice.datas.Store
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    val storeList = ArrayList<Store>()
    // 코드 후반부에 값초기화가 있을 경우를 대비해서 나중에 init한다는 키워드 추가
    private lateinit var mStoreAdapter : StoreAdapter

//   val 타입으로 변수를 선언하면서 추후 데이터를 초기화하고 싶은 경우 by lazy 키워드 사용
    val mpa:StoreAdapter by lazy {
        StoreAdapter(mContext, R.layout.store_list_item, storeList)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()

    }

    override fun setupEvents() {
        storeListView.setOnItemClickListener { parent, view, position, id ->
            val myIntent = Intent(mContext, StoreDetailActivity::class.java)
            val clickedStoreData = storeList.get(position)
            myIntent.putExtra("storeData", clickedStoreData)
            startActivity(myIntent)

        }
    }

    override fun setValues() {
        fetchPizzaStores()
        mStoreAdapter = StoreAdapter(mContext, R.layout.store_list_item, storeList)
        storeListView.adapter = mStoreAdapter

    }

    fun fetchPizzaStores() {
        storeList.add(Store("https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FnkQca%2FbtqwVT4rrZo%2FymhFqW9uRbzrmZTxUU1QC1%2Fimg.jpg",
            "피자헛","010-2186-5619"))
        storeList.add(Store("http://mblogthumb2.phinf.naver.net/20160530_65/ppanppane_1464617766007O9b5u_PNG/%C6%C4%C6%C4%C1%B8%BD%BA_%C7%C7%C0%DA_%B7%CE%B0%ED_%284%29.png?type=w800",
            "파파존스","010-1765-2159"))
        storeList.add(Store("https://post-phinf.pstatic.net/MjAxODEyMDVfMzYg/MDAxNTQzOTYxOTA4NjM3.8gsStnhxz7eEc9zpt5nmSRZmI-Pzpl4NJvHYU-Dlgmcg.7Vpgk0lopJ5GoTav3CUDqmXi2-_67S5AXD0AGbbR6J4g.JPEG/IMG_1641.jpg?type=w1200",
            "미스터피자","010-2234-1234"))
        storeList.add(Store("https://pbs.twimg.com/profile_images/1098371010548555776/trCrCTDN_400x400.png",
            "도미노피자","010-9626-5962"))
    }


}
