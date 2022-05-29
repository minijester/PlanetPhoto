package com.miharu.planetphoto.presenter.feature.apodlist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.miharu.planetphoto.R
import com.miharu.planetphoto.core.base.BaseFragment
import com.miharu.planetphoto.core.extension.clickAsFlow
import com.miharu.planetphoto.core.extension.viewBinding
import com.miharu.planetphoto.databinding.FragmentApodListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class ApodListFragment : BaseFragment(R.layout.fragment_apod_list) {

    private val binding by viewBinding(FragmentApodListBinding::bind)
    private val apodListViewModel: ApodListViewModel by viewModels()
    private val apodListAdapter by lazy { ApodListAdapter() }

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
                    apodListViewModel.getApodList()
                }.launchIn(lifecycleScope)
        }

        apodListViewModel.apodList.observe(viewLifecycleOwner) {
            apodListAdapter.updateList(it)
        }
    }
}