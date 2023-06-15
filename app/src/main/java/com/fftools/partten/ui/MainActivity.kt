package com.fftools.partten.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.fftools.partten.R
import com.fftools.partten.databinding.ActivityMainBinding
import com.fftools.partten.viewmodels.TestRetrofitModel
import com.fftools.partten.viewmodels.TestViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModelTest: TestViewModel by viewModel()
    private val viewModelRetrofit: TestRetrofitModel by viewModel()
    private val name = "BKIT"
    private var a = 0
    private var b = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initMain()
    }

    private fun initMain() {
        setData()
        setupListener()
        setupObservable()
    }

    private fun setData() {
        binding.btSum.setOnClickListener {
            a = binding.etA.text.toString().toInt()
            b = binding.etB.text.toString().toInt()
            viewModelTest.getData(a, b)
        }
    }

    private fun setupListener() {
        viewModelRetrofit.getData()
        viewModelRetrofit.testUIDataSate.observe(this) {
            val dataState = it ?: return@observe
            dataState.result?.let { result->
                Log.d("fjdla","$result")
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setupObservable() {
        viewModelTest.testUIDataSate.observe(this) {
            val dataState = it ?: return@observe
            binding.progressBar.visibility = if (dataState.isLoading) View.VISIBLE else View.GONE
            dataState.result?.let { result ->
                binding.tvResult.text = "$result"
            }?.run {
                dataState.error?.let { error ->
                    Log.d("error", error)
                }
            }
        }
    }
}