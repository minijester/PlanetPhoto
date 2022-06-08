package com.miharu.planetphoto.presenter.feature.apodlist

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.core.util.Pair
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.MaterialDatePicker
import com.miharu.planetphoto.R
import com.miharu.planetphoto.core.base.BaseFragment
import com.miharu.planetphoto.core.extension.*
import com.miharu.planetphoto.core.util.RangeValidator
import com.miharu.planetphoto.databinding.FragmentApodListBinding
import com.miharu.planetphoto.domain.model.ApodResponse
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.threeten.bp.LocalDate

@AndroidEntryPoint
class ApodListFragment : BaseFragment(R.layout.fragment_apod_list) {

    private val binding by viewBinding(FragmentApodListBinding::bind)
    private val apodListViewModel: ApodListViewModel by viewModels()
    private val apodListAdapter by lazy { ApodListAdapter() }

    @SuppressLint("UnsafeRepeatOnLifecycleDetector")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            apodRecyclerview.apply {
                layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                adapter = apodListAdapter
            }
            selectDateFab.clickAsFlow()
                .onEach {
                    showDatePicker()
                }.launchIn(lifecycleScope)
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                apodListViewModel.apodListUiState.collect { uiState ->
                    when (uiState) {
                        is ApodListUiState.Loading -> showLoading()
                        is ApodListUiState.Empty -> showEmptyList()
                        is ApodListUiState.Success -> updateData(uiState.apodList)
                    }
                }
            }
        }
    }

    private fun showLoading() {
        binding.apply {
            apodRecyclerview.visibility = View.GONE
            loadingProgressbar.show()
        }
    }

    private fun showEmptyList() {
        binding.apply {
            apodRecyclerview.visibility = View.GONE
            loadingProgressbar.hide()
        }
    }

    private fun updateData(apodList: List<ApodResponse>) {
        apodListAdapter.updateList(apodList)
        binding.apply {
            apodRecyclerview.visibility = View.VISIBLE
            loadingProgressbar.hide()
        }
    }


    private fun showDatePicker() {
        val minStartDate = LocalDate.parse(MIN_START_DATE).toEpochMills()
        val maxEndDate = LocalDate.now().toEpochMills()

        val dateCalendar = CalendarConstraints
            .Builder()
            .setStart(minStartDate)
            .setEnd(maxEndDate)
            .setOpenAt(maxEndDate)
            .setValidator(RangeValidator(minStartDate, maxEndDate))
            .build()

        childFragmentManager.let {
            MaterialDatePicker.Builder.dateRangePicker()
                .setCalendarConstraints(dateCalendar)
                .setTheme(R.style.Widget_AppTheme_MaterialDatePicker)
                .build()
                .apply {
                    addOnPositiveButtonClickListener {
                        getApodFromSelectedDateRange(it)
                    }
                    show(it, MaterialDatePicker.Builder.datePicker().javaClass.name)
                }
        }
    }

    private fun getApodFromSelectedDateRange(range: Pair<Long, Long>) {
        val selectedStartDate = range.first.toLocalDate().formatDefaultPattern()
        val selectedEndDate = range.second.toLocalDate().formatDefaultPattern()
        apodListViewModel.getApodList(selectedStartDate, selectedEndDate)
    }

    companion object {
        const val MIN_START_DATE = "1995-06-16"
    }
}