package com.curso.android.app.practica.comparadordestrings

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.curso.android.app.practica.comparadordestrings.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: TextComparisonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this).get(TextComparisonViewModel::class.java)

        binding.compareButton.setOnClickListener {
            val text1 = binding.editText1.text.toString()
            val text2 = binding.editText2.text.toString()
            viewModel.compareTexts(text1, text2)
        }

        viewModel.comparisonResult.observe(this, { result ->
            if (result) {
                binding.resultTextView.setTextColor(Color.GREEN)
                binding.resultTextView.text = "Ambos textos coinciden"
            } else {
                binding.resultTextView.setTextColor(Color.RED)
                binding.resultTextView.text = "Los textos no coinciden"
            }
        })
    }
}
