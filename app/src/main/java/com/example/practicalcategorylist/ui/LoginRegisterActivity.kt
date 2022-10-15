package com.example.practicalcategorylist.ui

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.practicalcategorylist.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_login_register.*

@AndroidEntryPoint
class LoginRegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_register)
        tabLogin.setOnClickListener {
            changeTheme("login")
        }

        tabRegister.setOnClickListener {
            changeTheme("register")
        }

        btnLogin.setOnClickListener {
            if (validateLoginFields()) {
                startActivity(Intent(this, MainActivity::class.java))
            }
        }

        btnRegister.setOnClickListener {
            if (validateRegisterFields()) {
                startActivity(Intent(this, MainActivity::class.java))

            }
        }


    }

    fun clearFileds() {
        etEmail1.setText("")
        etEmail2.setText("")
        etUserName.setText("")
        etPass1.setText("")
        etPass2.setText("")
    }

    fun validateLoginFields(): Boolean {
        val etEmail = etEmail1.text.toString()
        val passWord = etPass1.text.toString()

        if (etEmail.isEmpty()) {
            Toast.makeText(this, "Please enter email address", Toast.LENGTH_SHORT).show()
            return false
        } else if (!isValidEmail(etEmail)) {
            Toast.makeText(this, "Please enter valid email", Toast.LENGTH_SHORT).show()
            return false
        } else if (passWord.isEmpty()) {
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show()
            return false
        } else {
            return true
        }

    }


    fun validateRegisterFields(): Boolean {
        val etEmail = etEmail2.text.toString()
        val userName = etUserName.text.toString()
        val password = etPass2.text.toString()

        if (etEmail.isEmpty()) {
            Toast.makeText(this, "Please enter email address", Toast.LENGTH_SHORT).show()
            return false
        } else if (!isValidEmail(etEmail)) {
            Toast.makeText(this, "Please enter valid email", Toast.LENGTH_SHORT).show()
            return false
        } else if (userName.isEmpty()) {
            Toast.makeText(this, "Please enter userName", Toast.LENGTH_SHORT).show()
            return false
        } else if (password.isEmpty()) {
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show()
            return false
        } else {
            return true
        }

    }

    fun isValidEmail(target: CharSequence?): Boolean {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }

    fun changeTheme(selectedTab: String) {
        if (selectedTab == "login") {
            tabRegister.background = null
            tabLogin.background = this.getDrawable(R.drawable.bg_off_white)
            viewLogin.visibility = View.VISIBLE
            viewRegister.visibility = View.GONE
        } else {
            tabRegister.background = this.getDrawable(R.drawable.bg_off_white)
            tabLogin.background = null
            viewLogin.visibility = View.GONE
            viewRegister.visibility = View.VISIBLE
        }
        clearFileds()
    }
}