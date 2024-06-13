package com.example.metabook.view.main.ui.search

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.metabook.data.ItemsItem
import com.example.metabook.databinding.FragmentSearchBinding
import com.example.metabook.helper.OnItemClickCallback
import com.example.metabook.helper.constant
import com.example.metabook.view.main.ui.detailbook.DetailBookActivity
import com.example.metabook.view.main.ui.home.adapter.BookTabbarAdapter

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null

    private val binding get() = _binding!!

    private var _viewModel: SearchViewModel? = null
    private val viewModel get() = _viewModel as SearchViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)

        _viewModel = ViewModelProvider(this)[SearchViewModel::class.java]

        setUpSortByMenu()


        return binding.root
    }

    override fun onResume() {
        super.onResume()
        binding.cvSortBy.visibility = View.GONE
    }

    private fun setUpSortByMenu() {
        binding.svBook.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.searchBookWithoutTerms(query)
                binding.cvSortBy.visibility = View.GONE
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                binding.apply {
                    cvSortBy.visibility = View.VISIBLE
                    tvSearchTitle.text = newText
                    tvSearchCategory.text = newText
                    tvSearchPublisher.text = newText
                    tvSearchAuthor.text = newText
                }
                newText?.let { searchByCategory(it) }
                Log.i("NewText", "onQueryTextChange: $newText")
                return false
            }

        })
        binding.svBook.setOnQueryTextFocusChangeListener { _, b ->
            if (!b) {
                binding.cvSortBy.visibility = View.GONE
            } else {
                binding.cvSortBy.visibility = View.VISIBLE
            }
        }
    }

    private fun searchByCategory(text: String) {
        binding.apply {
            cvSearchTitle.setOnClickListener {
                viewModel.searchBookInTitle(text)
                binding.cvSortBy.visibility = View.GONE

            }
            cvSearchAuthor.setOnClickListener {
                viewModel.searchBookInAuthor(text)
                binding.cvSortBy.visibility = View.GONE

            }
            cvSearchCategory.setOnClickListener {
                viewModel.searchBookInCategory(text)
                binding.cvSortBy.visibility = View.GONE

            }
            cvSearchPublisher.setOnClickListener {
                viewModel.searchBookInPublisher(text)
                binding.cvSortBy.visibility = View.GONE

            }
        }

        viewModel.booksResponse.observe(viewLifecycleOwner) {
            setupRecyclerView(it.items)
            Log.i("ExploreFragment", "searchByCategory: ${it.items}")
        }
    }

    fun setupRecyclerView(data: List<ItemsItem>?) {
        binding.rvExplore.apply {
            val mAdapter = BookTabbarAdapter()
            mAdapter.setData(data)
            adapter = mAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            mAdapter.setOnItemClickCallback(object : OnItemClickCallback {
                override fun onItemClicked(data: ItemsItem) {
                    startActivity(
                        Intent(context, DetailBookActivity::class.java)
                            .putExtra(constant.EXTRA_BOOK_INTENT, data)
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