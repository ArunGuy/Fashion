package com.arunwichsapplication.app.modules.result.ui

import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import com.arunwichsapplication.app.R
import com.arunwichsapplication.app.appcomponents.base.BaseActivity
import com.arunwichsapplication.app.databinding.ActivityResultBinding
import com.arunwichsapplication.app.modules.result.`data`.model.ResultRowModel
import com.arunwichsapplication.app.modules.result.`data`.model.SpinnerFrame2441Model
import com.arunwichsapplication.app.modules.result.`data`.viewmodel.ResultVM
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit

class ResultActivity : BaseActivity<ActivityResultBinding>(R.layout.activity_result) {
  private val viewModel: ResultVM by viewModels<ResultVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    viewModel.spinnerFrame2441List.value = mutableListOf(
    SpinnerFrame2441Model("Item1"),
    SpinnerFrame2441Model("Item2"),
    SpinnerFrame2441Model("Item3"),
    SpinnerFrame2441Model("Item4"),
    SpinnerFrame2441Model("Item5")
    )
    val spinnerFrame2441Adapter =
    SpinnerFrame2441Adapter(this,R.layout.spinner_item,viewModel.spinnerFrame2441List.value?:
    mutableListOf())
    binding.spinnerFrame2441.adapter = spinnerFrame2441Adapter
    val resultAdapter = ResultAdapter(viewModel.resultList.value?:mutableListOf())
    binding.recyclerResult.adapter = resultAdapter
    resultAdapter.setOnItemClickListener(
    object : ResultAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : ResultRowModel) {
        onClickRecyclerResult(view, position, item)
      }
    }
    )
    viewModel.resultList.observe(this) {
      resultAdapter.updateData(it)
    }
    binding.resultVM = viewModel
    setUpSearchViewFrame2432Listener()
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  fun onClickRecyclerResult(
    view: View,
    position: Int,
    item: ResultRowModel
  ): Unit {
    when(view.id) {
    }
  }

  private fun setUpSearchViewFrame2432Listener(): Unit {
    binding.searchViewFrame2432.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
      override fun onQueryTextSubmit(p0 : String) : Boolean {
        // Performs search when user hit
        // the search button on the keyboard
        return false
      }
      override fun onQueryTextChange(p0 : String) : Boolean {
        // Start filtering the list as user
        // start entering the characters
        return false
      }
      })
    }

    companion object {
      const val TAG: String = "RESULT_ACTIVITY"

    }
  }
