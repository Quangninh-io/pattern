package com.fftools.projectorremote.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.fftools.projectorremote.adapter.BrandListAdapter
import com.fftools.projectorremote.databinding.ActivityMainBinding
import com.fftools.projectorremote.model.ProjectorBrandEntity
import com.fftools.projectorremote.viewmodel.ProjectorViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val projectorViewModel: ProjectorViewModel by viewModel()
    private lateinit var adapter: BrandListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initMain()
    }

    private fun initMain() {
        initView()
        setRecycleView()
        setData()
        addEvent()
        setupObservable()
    }

    private fun setupObservable() {
        projectorViewModel.listBrandState.observe(this) {
            val state = it ?: return@observe
            binding.pb.visibility = if (state.isLoading) View.VISIBLE else View.GONE
            state.result?.let {  result ->
                adapter.submitList(result)
            }?.run {
                state.error?.let { error ->
                    Log.d("errorMain", error)
                }
            }
        }
    }

    private fun addEvent() {

    }

    private fun setData() {
        projectorViewModel.getAllBrandList()
    }

    private fun setRecycleView() {
        adapter = BrandListAdapter(this)
        binding.rv.adapter = adapter
        binding.rv.layoutManager = LinearLayoutManager(this)

    }

    private fun initView() {

    }
}