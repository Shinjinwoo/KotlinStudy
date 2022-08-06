package com.example.kotlinstudy.viewholder

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinstudy.App
import com.example.kotlinstudy.clickinterface.MyRecyclerViewInterface
import com.example.kotlinstudy.modle.DataModel
import kotlinx.android.synthetic.main.layout_recycler_item.view.*


class MyViewHolder(itemView: View,
                   recyclerViewInterface: MyRecyclerViewInterface
):
                    RecyclerView.ViewHolder(itemView),
                    View.OnClickListener
{

    val TAG: String = "로그"

    private var myRecyclerViewInterface : MyRecyclerViewInterface? = null

    private val usernameTextView = itemView.user_name_txt
    private val profileImageView = itemView.profile_img

    // 기본 생성자
    init {
        Log.d(TAG, "MyViewHolder - init() called")

        itemView.setOnClickListener(this)
        this.myRecyclerViewInterface = recyclerViewInterface
    }

    // 데이터와 뷰를 묶는다.
    fun bind(dataModel: DataModel){
        Log.d(TAG, "MyViewHolder - bind() called")

        usernameTextView.text = dataModel.name

        Glide
            .with(App.instance)
            .load(dataModel.profileImage)
            .into(profileImageView)
    }

    override fun onClick(p0: View?) {
        Log.d(TAG,"MyViewHolder - onClick() called")
        this.myRecyclerViewInterface?.onItemClicked(adapterPosition)
    }
}