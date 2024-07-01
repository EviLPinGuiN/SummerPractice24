package ru.itis.summerpractice24.day1

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.google.android.material.snackbar.Snackbar
import ru.itis.summerpractice24.R
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
        viewBinding?.run {
            emailEt.doOnTextChanged { text, start, before, count ->
                text?.let {
                    sendTextBtn.isEnabled = emailPattern.matcher(text).matches()
                }
            }

            sendTextBtn.setOnClickListener {
                Snackbar.make(root, "Current Email: ${emailEt.text}", Snackbar.LENGTH_LONG).show()
//                Toast.makeText(this@MainActivity, "Current Email: ${emailEt.text}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewBinding = null
    }
}
