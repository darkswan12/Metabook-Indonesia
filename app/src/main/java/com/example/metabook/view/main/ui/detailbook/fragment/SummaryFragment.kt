package com.example.metabook.view.main.ui.detailbook.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.metabook.data.ItemsItem
import com.example.metabook.databinding.FragmentSummaryBinding
import com.example.metabook.helper.OnItemClickCallback
import com.example.metabook.helper.constant
import com.example.metabook.view.main.ui.detailbook.DetailBookActivity
import com.example.metabook.view.main.ui.detailbook.DetailViewModel
import com.example.metabook.view.main.ui.home.adapter.BookRecommendationsAdapter

class SummaryFragment : Fragment() {

    private var _binding: FragmentSummaryBinding? = null

    private val binding get() = _binding!!

    private var _viewModel: DetailViewModel? = null
    private val viewModel get() = _viewModel

    private lateinit var id: String
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSummaryBinding.inflate(inflater, container, false)
        _viewModel = ViewModelProvider(this)[DetailViewModel::class.java]
        val getRandomBookCategories = constant.BooksRecommendation.random()
        viewModel?.getSimiliarBooks(getRandomBookCategories)
        viewModel?.booksResponse?.observe(viewLifecycleOwner) { setupRecyclerViewDetail(it.items) }

        id = viewModel?.getRecentBookId().toString()
        viewModel?.getBooksById(id)
        viewModel?.recentBooksResponse?.observe(viewLifecycleOwner){ setUpRecentViewedBook(it) }


        return binding.root
    }

    private fun setUpRecentViewedBook(it: ItemsItem?) {
        binding.apply {
            val page = it?.volumeInfo?.pageCount
            val categories = it?.volumeInfo?.categories
            val publisherbook = it?.volumeInfo?.publisher
            val publisherdate = it?.volumeInfo?.publishedDate
            val descriptionbook = it?.volumeInfo?.description
            binding.bookDetailPagesNumber.text = page.toString()
            binding.bookDetailCategories.text = categories.toString()
            binding.bookDetailPublisher.text = publisherbook.toString()
            binding.bookDetailPublishDate.text = publisherdate.toString()
            binding.DescriptionBook.text = descriptionbook
        }

    }


    private fun setupRecyclerViewDetail(books: List<ItemsItem>?) {
        binding.rvDetailRecommendations.apply {
            val mAdapter = BookRecommendationsAdapter()
            mAdapter.setData(books)
            adapter = mAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
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
}
