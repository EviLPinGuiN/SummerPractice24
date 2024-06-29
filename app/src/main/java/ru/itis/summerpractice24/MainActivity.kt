package ru.itis.summerpractice24

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import ru.itis.summerpractice24.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var header: TextView? = null
    private var sendTextButton: Button? = null

    private var viewBinding: ActivityMainBinding? = null

    private val emailPattern = Patterns.EMAIL_ADDRESS

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Для классической инициализации View
        // setContentView(R.layout.activity_main)
        // initViewsClassic()
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding?.root)
        initViewsModern()
    }

    private fun initViewsClassic() {
        this.header = findViewById(R.id.header_tv)
        this.sendTextButton = findViewById(R.id.send_text_btn)
        var counter = 0

        sendTextButton?.setOnClickListener {
            header?.text = "Button Clicked ${++counter} times"
            // Toast.makeText(this, "Button clicked ${++counter}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initViewsModern() {
        viewBinding?.apply {
            emailEt.doOnTextChanged { text, start, before, count ->
                text?.let {
                    sendTextBtn.isEnabled = emailPattern.matcher(text).matches()
                }
            }

            sendTextBtn.setOnClickListener {
                Toast.makeText(this@MainActivity, "Current Email: ${emailEt.text}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}

fun appendString(arg1: String, arg2: String, userDataSecond: UserDataSecond): String? {
    return userDataSecond.phone?.let { safePhone ->
        println("UserPhone: $safePhone")
        "userDataSecond.address;$safePhone"
    }
//
//    return if (userDataSecond.phone != null) {
//        println("UserPhone: ${userDataSecond.phone}")
//        "userDataSecond.address;${userDataSecond.phone}"
//    } else {
//        ""
//    }
}

fun testFun(userPhone: String): String {
    println("UserPhone: $userPhone")
    return userPhone
}

open class User(
    open val name: String,
    var age: Int,
    val userData: UserData,
    email: String,
) {

    private var userInfo: String = ""

    init {
        userInfo = "$name;${age * 10};$email;${userData.address}" //
    }

    companion object {
        // final static String sampleValue = new String("sad")
        const val sampleValue = "sad"
    }
}

class UserData(
    val address: String,
    val phone: String,
)

data class UserDataSecond(
    val address: String = "sampleUserAddress",
    val phone: String?,
)

class EmailUser(
    override val name: String,
    age: Int,
    userData: UserData,
    email: String,
) : User(
    name = name,
    age = age,
    userData = userData,
    email = email,
), UserAction, EmailAction, PhoneAction {

    override fun doSomething() {
        println("Result action")
    }
}

interface UserAction {

    fun doSomething()
}

interface EmailAction

interface PhoneAction

