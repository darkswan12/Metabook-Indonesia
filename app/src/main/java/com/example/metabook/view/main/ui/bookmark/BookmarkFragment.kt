package com.example.metabook.view.main.ui.bookmark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.metabook.databinding.FragmentBookmarkBinding
import com.example.metabook.view.main.ui.bookmark.adapter.BookmarkAdapter


class BookmarkFragment : Fragment() {

    private var _binding: FragmentBookmarkBinding? = null
    private val binding get() = _binding!!

    private var _viewModel: BookmarkViewModel? = null
    private val viewModel get() = _viewModel as BookmarkViewModel


    private lateinit var mAdapter: BookmarkAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBookmarkBinding.inflate(inflater, container, false)

        _viewModel = ViewModelProvider(this)[BookmarkViewModel::class.java]
        mAdapter = BookmarkAdapter()

        setUpRecyclerView()
        return binding.root
    }

    private fun setUpRecyclerView() {
        viewModel.getBookmark().observe(viewLifecycleOwner){
            mAdapter.setData(it)
        }
        binding.rvBookmark.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}