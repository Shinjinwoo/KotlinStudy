package com.example.kotlinstudy.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinstudy.clickinterface.MyRecyclerViewInterface
import com.example.kotlinstudy.R
import com.example.kotlinstudy.modle.DataModel
import com.example.kotlinstudy.viewholder.MyViewHolder

class MyRecyclerAdapter(myRecyclerViewInterface: MyRecyclerViewInterface) : RecyclerView.Adapter<MyViewHolder>(){

    var TAG : String = "로그"

    private var modelList = ArrayList<DataModel>()
    private var myRecyclerViewInterface : MyRecyclerViewInterface? = null

    init {
        this.myRecyclerViewInterface = myRecyclerViewInterface
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        Log.d(TAG,"MyRecyclerAdapter - onCreateViewHolder() called")

        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_recycler_item,parent,false),this.myRecyclerViewInterface!!)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Log.d(TAG,"MyRecyclerAdapter - onBindViewHolder() called / position : $position")
        holder.bind(this.modelList[position])
        // 클릭 이벤트

//        holder.itemView.setOnClickListener{
//            Toast.makeText(App.instance,"클릭됨",Toast.LENGTH_SHORT).show()
//        }
    }

    override fun getItemCount(): Int {
        return this.modelList.size
    }

    fun submitList(modelList: ArrayList<DataModel>) {
        this.modelList = modelList
    }


}