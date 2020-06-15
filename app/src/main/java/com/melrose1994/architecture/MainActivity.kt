package com.melrose1994.architecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.melrose1994.baselibrary.ioc.ui.ContentView
import com.melrose1994.baselibrary.ioc.ui.OnClick
import com.melrose1994.baselibrary.ioc.ui.ViewById
import com.melrose1994.baselibrary.ioc.ui.inject


@ContentView(R.layout.activity_main)
class MainActivity : AppCompatActivity() {

    @ViewById(R.id.tvMessage)
    private lateinit var mTextView:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
        mTextView.text = "Melrose"
    }


    @OnClick(intArrayOf(R.id.tvMessage))
    private fun onTextClick(v: View){
        Toast.makeText(this,"text click",Toast.LENGTH_SHORT).show()
    }
}
