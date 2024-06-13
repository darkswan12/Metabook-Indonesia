package com.example.metabook.view.main.ui.bookmark.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.metabook.data.local.room.Book
import com.example.metabook.databinding.RowItemHomeTabBarBinding
import com.example.metabook.helper.BookDiffUtil
import com.example.metabook.helper.constant
import com.example.metabook.view.main.ui.detailbook.DetailBookActivity


class BookmarkAdapter:RecyclerView.Adapter<BookmarkAdapter.MyViewHolder>() {

    private var listBooksTabbar = ArrayList<Book>()

    fun setData(newList: List<Book>) {
        val bookDiffUtil = BookDiffUtil(listBooksTabbar, newList)
        val diffUtilResult = DiffUtil.calculateDiff(bookDiffUtil)
        listBooksTabbar.clear()
        listBooksTabbar.addAll(newList)
        diffUtilResult.dispatchUpdatesTo(this)
    }

    class MyViewHolder(val binding: RowItemHomeTabBarBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        RowItemHomeTabBarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = listBooksTabbar[position]

        holder.binding.apply {
            tvTitleBook.text = data.title
            tvAuthorBook.text = data.author
            tvRatingBook.text = data.rating
            tvDescBook.text = data.description
            Glide.with(imgBook.context)
                .load(data.imageUrl)
                .apply(RequestOptions())
                .override(500, 500)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH)
                .into(imgBook)
        }

        holder.itemView.setOnClickListener {
            holder.binding.tvDescBook.context.startActivity(
                Intent(holder.binding.tvDescBook.context, DetailBookActivity::class.java)
                    .putExtra(constant.EXTRA_BOOKMARK_INTENT, data)
                    .putExtra(constant.EXTRA_ORIGIN, constant.EXTRA_ORIGIN_BOOKMARK)
            )
        }
    }

    override fun getItemCount(): Int = listBooksTabbar.size
}