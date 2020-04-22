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
import org.w3c.dom.Text
class StoreAdapter (context : Context, resID:Int, list:ArrayList<Store>)  : ArrayAdapter<Store>(context, resID, list)  {
    val mContext = context
    val mList = list
    val inf = LayoutInflater.from(mContext)

// Swift에서 하나의 테이블뷰 아이템을 만드는 함수와 기능이 같음
// getView는 indexpath.row와 유사함 => 각 줄에 뿌려줄 내용을 결정
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        if (tempRow == null) {
            tempRow = inf.inflate(R.layout.store_list_item, null)
//            미리 만들어놓은 레이아웃(XML)파일을 inf()함수를 거쳐서 내가 뿌려줄 리스트에 연결
        }
//    위에서 이미 null 체크가 끝났으므로 내가 가져올 리스트 아이템은 !!를 사용해 강제 언랩핑해서 사용 준비
        val row = tempRow!!
//    XML에 있는 뷰들을 변수로 담기, 해당 뷰들의 값들을 뿌려줄때 변경하기 위함
        val storeName = row.findViewById<TextView>(R.id.storeNameText)
        val storeLogoImg = row.findViewById<ImageView>(R.id.storeLogoImg)

        addressText.text = "${data.address}, ${floorStr}"
        descText.text = data.desc


//    최종적으로 화면에 뿌려질 하나의 리스트(row)를 최종적으로 return
        return  row

    }

}