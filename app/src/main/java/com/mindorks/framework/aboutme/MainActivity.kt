package com.mindorks.framework.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.mindorks.framework.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var Binding: ActivityMainBinding

    private val myName: MyName = MyName("Vaibhavi Sahukar")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        Binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        Binding.myName = myName

//        findViewById<Button>(R.id.button).setOnClickListener {
//            addNickName(it)
//        }
        Binding.button.setOnClickListener {
            addNickName(it)
        }

    }

    fun addNickName(view: View) {
//        val text_nickname = findViewById<TextView>(R.id.textnickname)
//        val edit_nickname = findViewById<EditText>(R.id.nickname_edit)

        Binding.apply {
            //textnickname.text = Binding.nicknameEdit.text
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            view.visibility = View.GONE
            textnickname.visibility = View.VISIBLE
        }


        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

}