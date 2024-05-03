package com.arunwichsapplication.app.modules.result.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import com.arunwichsapplication.app.R
import com.arunwichsapplication.app.appcomponents.base.BaseActivity
import com.arunwichsapplication.app.databinding.ActivityResultBinding
import com.arunwichsapplication.app.modules.result.data.model.ResultRowModel
import com.arunwichsapplication.app.modules.result.data.model.SpinnerFrame2441Model
import com.arunwichsapplication.app.modules.result.data.viewmodel.ResultVM


class ResultActivity : BaseActivity<ActivityResultBinding>(R.layout.activity_result) {
  private val viewModel: ResultVM by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    viewModel.spinnerFrame2441List.value = mutableListOf(
      SpinnerFrame2441Model("Item1"),
      SpinnerFrame2441Model("Item2"),
      SpinnerFrame2441Model("Item3"),
      SpinnerFrame2441Model("Item4"),
      SpinnerFrame2441Model("Item5")
    )
    val spinnerFrame2441Adapter = SpinnerFrame2441Adapter(this, R.layout.spinner_item, viewModel.spinnerFrame2441List.value?: mutableListOf())
    binding.spinnerFrame2441.adapter = spinnerFrame2441Adapter

    val resultAdapter = ResultAdapter(viewModel.resultList.value ?: mutableListOf()) { position, item ->
      onClickRecyclerResult(position, item)
    }
    binding.recyclerResult.adapter = resultAdapter
    viewModel.resultList.observe(this) {
      resultAdapter.updateData(it)
    }

    val testData = mutableListOf(
      ResultRowModel(
        txtFiveResourceId = "First Product",
        txtSixResourceId = "100",
        txtNumbersoldResourceId = R.drawable.testsk // ใช้ชื่อของรูปภาพใน drawable แทน
      ),
      ResultRowModel(
        txtFiveResourceId = "Second Product",
        txtSixResourceId = "200",
        txtNumbersoldResourceId = R.drawable.dress // ใช้ชื่อของรูปภาพใน drawable แทน
      ),
      ResultRowModel(
        txtFiveResourceId = " Product",
        txtSixResourceId = "100",
        txtNumbersoldResourceId = R.drawable.testsk // ใช้ชื่อของรูปภาพใน drawable แทน
      ),
      ResultRowModel(
        txtFiveResourceId = "Second ",
        txtSixResourceId = "200",
        txtNumbersoldResourceId = R.drawable.dress // ใช้ชื่อของรูปภาพใน drawable แทน
      ),
    )




    val testAdapter = ResultAdapter(testData) { position, item ->
      onClickRecyclerResult(position, item)
    }
    binding.recyclerResult.adapter = testAdapter


    binding.resultVM = viewModel
    setUpSearchViewFrame2432Listener()
  }

  override fun setUpClicks() {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  private fun onClickRecyclerResult(position: Int, item: ResultRowModel) {
    // Handle item click
  }

  private fun setUpSearchViewFrame2432Listener() {
    binding.searchViewFrame2432.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
      override fun onQueryTextSubmit(p0: String): Boolean {
        // Performs search when user hits the search button on the keyboard
        return false
      }

      override fun onQueryTextChange(p0: String): Boolean {
        // Start filtering the list as the user starts entering characters
        return false
      }
    })
  }

  companion object {
    const val TAG: String = "RESULT_ACTIVITY"
  }
}
