package au.edu.swin.sdmd.w09_counter

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel

class MainActivity : AppCompatActivity() {
    private val tapsViewModel: CounterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val label = findViewById<TextView>(R.id.counter)
        val button = findViewById<Button>(R.id.count)

        label.text = tapsViewModel.tapCount.toString()

        button.setOnClickListener {
            tapsViewModel.updateTaps()
            label.text = tapsViewModel.tapCount.toString()
        }

    }

}

class CounterViewModel: ViewModel() {
    var tapCount = 0

    fun updateTaps() {
        ++tapCount
    }

}