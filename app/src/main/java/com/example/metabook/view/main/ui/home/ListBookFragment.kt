package com.example.metabook.view.main.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.metabook.data.ItemsItem
import com.example.metabook.databinding.FragmentListBookBinding
import com.example.metabook.helper.OnItemClickCallback
import com.example.metabook.helper.constant
import com.example.metabook.view.main.ui.detailbook.DetailBookActivity
import com.example.metabook.view.main.ui.home.adapter.BookTabbarAdapter


class ListBookFragment() : Fragment() {

    private var _binding: FragmentListBookBinding? = null
    private val binding get() = _binding as FragmentListBookBinding

    private var _viewModel: HomeViewModel? = null
    private val viewModel get() = _viewModel as HomeViewModel

    private lateinit var getCategory: String
    private lateinit var mAdapter: BookTabbarAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentListBookBinding.inflate(layoutInflater)
        _viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        mAdapter = BookTabbarAdapter()

//        setupRecyclerView()

        getCategory = arguments?.getString(constant.VIEWPAGER_TITlE_KEY).toString()

        viewModel.getRandomBooksByCategory(getCategory)

        viewModel.booksResponse.observe(viewLifecycleOwner) {
            setUpRecyclerView(it.items)
        }


        return binding.root
    }

    private fun setUpRecyclerView(data: List<ItemsItem>?) {
        binding.rvHomeTabBar.apply {
            mAdapter.setData(data)
            adapter = mAdapter
            layoutManager = LinearLayoutManager(context)
            mAdapter.setOnItemClickCallback(object : OnItemClickCallback {
                override fun onItemClicked(item: ItemsItem) {
                    startActivity(
                        Intent(context, DetailBookActivity::class.java)
                            .putExtra(constant.EXTRA_BOOK_INTENT, item)
                    )
                }
            })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}