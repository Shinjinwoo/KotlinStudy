package com.example.kotlinstudy

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinstudy.adapter.MyRecyclerAdapter
import com.example.kotlinstudy.clickinterface.MyRecyclerViewInterface
import com.example.kotlinstudy.modle.DataModel
import kotlinx.android.synthetic.main.activity_rc_view.*

class MainActivity : AppCompatActivity(),MyRecyclerViewInterface {

    var TAG: String = "로그"
    var modelList = ArrayList<DataModel>()
    private lateinit var myRecyclerAdapter: MyRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rc_view)

        var imageExample: String? =
            "data:image/jpeg;base64,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"

        Log.d(TAG, "MainActivity - onCreate() called")

//        someCallbackMethod(completion = {
//            Log.d(TAG, "MainActivity - 컴플레이션 블럭 호출됨 / it : $it")
//        })
        Log.d(TAG, "MainActivity - 반복문 돌리기 전 this.modelList.size : ${this.modelList.size}")

        // 10번 반복한다.
        for (i in 1..10) {
            val myModel = DataModel(name = "웰시코딩 $i", imageExample)
            this.modelList.add(myModel)
        }

        Log.d(TAG, "MainActivity - 반복문 돌린 후 this.modelList.size : ${this.modelList.size}")

        //어답터 인스턴스 생성
        myRecyclerAdapter = MyRecyclerAdapter(this)
        myRecyclerAdapter.submitList(this.modelList)


        my_recycler_view.apply {
            // 리사이클러뷰 설정
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = myRecyclerAdapter
        }

    }

    override fun onItemClicked(position:Int) {

        var name: String? = null

        var title: String = this.modelList[position].name ?: ""

        AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage("민지와 함께하는 빡코딩 :) ")
            .setPositiveButton("연봉 5천 드가자") {
                //5000으로 멈추지 않아 !
                // 더 높이 날아갈거야

                dialog,id ->
                Log.d(TAG,"MainActivity - onItemClicked() -> 다이얼로그 확인버튼 클릭")
                Toast.makeText(App.instance,"가주아아아아아아악",Toast.LENGTH_LONG).show()
            }
            .show()
    }

}

fun someCallbackMethod(completion: (String) -> Unit) {
    Log.d(TAG, "MainActivity - someCallbackMethod() called")
    Handler().postDelayed({
        completion("종료")
    }, 3000L)
}

// CallBack Hell 예시

fun someCallbackMethod2(completion: (String) -> Unit) {
    Log.d(TAG, "MainActivity - someCallbackMethod() called")
    Handler().postDelayed({
        completion("종료")
    }, 3000L)
}

fun someCallbackMethod3(completion: (String) -> Unit) {
    Log.d(TAG, "MainActivity - someCallbackMethod() called")
    Handler().postDelayed({
        completion("종료")
    }, 3000L)
}

fun someCallbackMethod4(completion: (String) -> Unit) {
    Log.d(TAG, "MainActivity - someCallbackMethod() called")
    Handler().postDelayed({
        completion("종료")
    }, 3000L)
}

fun someCallbackMethod5(completion: (String) -> Unit) {
    Log.d(TAG, "MainActivity - someCallbackMethod() called")
    Handler().postDelayed({
        completion("종료")
    }, 3000L)
}

fun someCallbackMethod6(completion: (String) -> Unit) {
    Log.d(TAG, "MainActivity - someCallbackMethod() called")
    Handler().postDelayed({
        completion("종료")
    }, 3000L)
}

fun someCallbackMethod7(completion: (String) -> Unit) {
    Log.d(TAG, "MainActivity - someCallbackMethod() called")
    Handler().postDelayed({
        completion("종료")
    }, 3000L)
}

fun someCallbackMethod8(completion: (String) -> Unit) {
    Log.d(TAG, "MainActivity - someCallbackMethod() called")
    Handler().postDelayed({
        completion("종료")
    }, 3000L)
}

