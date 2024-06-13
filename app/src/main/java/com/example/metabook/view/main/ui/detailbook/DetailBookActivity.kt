package com.example.metabook.view.main.ui.detailbook

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.metabook.R
import com.example.metabook.data.ItemsItem
import com.example.metabook.data.local.room.Book
import com.example.metabook.databinding.ActivityDetailBookBinding
import com.example.metabook.helper.HelperFunction
import com.example.metabook.helper.constant
import com.example.metabook.view.main.ui.detailbook.fragment.AuthorFragment
import com.example.metabook.view.main.ui.detailbook.fragment.ReviewFragment
import com.example.metabook.view.main.ui.detailbook.fragment.SummaryFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class DetailBookActivity : AppCompatActivity() {

    private lateinit var tabLayout : TabLayout
    private lateinit var viewPager : ViewPager2
    private var _binding: ActivityDetailBookBinding? = null
    private val binding get() = _binding as ActivityDetailBookBinding

    private var _viewModel: DetailViewModel? = null
    private val viewModel get() = _viewModel as DetailViewModel
    lateinit var rating: String

    private var intentData: ItemsItem? = null
    private var intentBookmark: Book? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityDetailBookBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()

        tabLayout = findViewById(R.id.tabs)
        viewPager = findViewById(R.id.view_pager)

        val pageAdapter = SectionPageAdapter (supportFragmentManager,lifecycle)
        pageAdapter.addFragment(SummaryFragment(),"Summary")
        pageAdapter.addFragment(ReviewFragment(),"Review")
        pageAdapter.addFragment(AuthorFragment(),"Author")
        supportActionBar?.hide()
        viewPager.adapter = pageAdapter
        TabLayoutMediator(tabLayout,viewPager){tab,position ->
            tab.text = pageAdapter.getPageTitle(position)
        }.attach()

        _viewModel = ViewModelProvider(this)[DetailViewModel::class.java]
        if(intent.getStringExtra(constant.EXTRA_ORIGIN) == constant.EXTRA_ORIGIN_BOOKMARK){
            intentBookmark = intent.getParcelableExtra(constant.EXTRA_BOOKMARK_INTENT)
        } else {
            intentData = intent.getParcelableExtra(constant.EXTRA_BOOK_INTENT)
        }

        setUpDetail()
        setUpFavoriteFeature()

        val bookId = intentData?.id
        bookId?.let { saveRecentViewedBook(it) }
    }
    private fun setUpFavoriteFeature() {
        binding.apply {
            btnFavorite.setOnClickListener {
                if (btnFavorite.isChecked) {
                    var bookmarkBook = Book(
                        intentData?.id!!,
                        intentData?.volumeInfo?.title!!,
                        intentData?.volumeInfo?.authors?.get(0)!!,
                        intentData?.volumeInfo?.description!!,
                        intentData?.volumeInfo?.imageLinks?.thumbnail!!,
                        rating,
                    )
                    viewModel.addBookmark(bookmarkBook)
                    Toast.makeText(applicationContext, "${intentData?.volumeInfo?.title} added to bookmark", Toast.LENGTH_SHORT).show()
                } else {
                    intentBookmark?.let { it1 ->
                        viewModel.deleteBookmark(
                            it1
                        )
                    }
                }
            }
        }
    }

    private fun setUpDetail() {
        var authors = ""
        var image: String? = ""
        var desc: String? = ""
        var title: String? = ""
        if (intentData != null){
            rating = (intentData?.volumeInfo?.averageRating
                ?: (1..9).random()).toString() + "." + (intentData?.volumeInfo?.averageRating
                ?: (1..9).random()).toString()
            if (intentData?.volumeInfo?.authors != null) {
                authors = intentData!!.volumeInfo?.authors?.joinToString(", ") ?: ""
            } else {
                authors = "-"
            }
            if (intentData?.volumeInfo?.imageLinks?.large != null) {
                image = intentData?.volumeInfo!!.imageLinks?.large
            } else {
                image = intentData?.volumeInfo?.imageLinks?.thumbnail
            }
            desc = intentData?.volumeInfo?.description
            title = intentData?.volumeInfo?.title
        } else {
            binding.btnFavorite.isChecked = true
            rating = intentBookmark?.rating ?: "0.0"
            if (intentBookmark?.author != null) {
                authors = intentBookmark!!.author
            } else {
                authors = "-"
            }
            image = intentBookmark?.imageUrl
            desc = intentBookmark?.description
            title = intentBookmark?.title
        }


        binding.apply {
            tvBookTitle.text = title
            //tvDescBook.text = desc
            tvBookAuthor.text = authors
            tvBookRating.text = rating

            Glide.with(this@DetailBookActivity)
                .load(image)
                .apply(RequestOptions())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH)
                .into(imgBookDetail)


            cvBookCover.setCardBackgroundColor(HelperFunction.generateRandomColor())

            btnBack.setOnClickListener {
                finish()
            }
        }

    }

    private fun saveRecentViewedBook(id: String) {
        viewModel.saveRecentBookId(id)
    }
   /*

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBookBinding.inflate(layoutInflater)
        setContentView(binding.root)

        _viewModel = ViewModelProvider(this)[DetailViewModel::class.java]
        if(intent.getStringExtra(constant.EXTRA_ORIGIN) == constant.EXTRA_ORIGIN_BOOKMARK){
            intentBookmark = intent.getParcelableExtra(constant.EXTRA_BOOKMARK_INTENT)
        } else {
            intentData = intent.getParcelableExtra(constant.EXTRA_BOOK_INTENT)
        }

        setUpDetail()
        setUpFavoriteFeature()

        val bookId = intentData?.id
        bookId?.let { saveRecentViewedBook(it) }
    }

    private fun setUpFavoriteFeature() {
        binding.apply {
            btnFavorite.setOnClickListener {
                if (btnFavorite.isChecked) {
                    var bookmarkBook = Book(
                        intentData?.id!!,
                        intentData?.volumeInfo?.title!!,
                        intentData?.volumeInfo?.authors?.get(0)!!,
                        intentData?.volumeInfo?.description!!,
                        intentData?.volumeInfo?.imageLinks?.thumbnail!!,
                        rating,
                    )
                    viewModel.addBookmark(bookmarkBook)
                    Toast.makeText(applicationContext, "${intentData?.volumeInfo?.title} added to bookmark", Toast.LENGTH_SHORT).show()
                } else {
                    intentBookmark?.let { it1 ->
                        viewModel.deleteBookmark(
                            it1
                        )
                    }
                }
            }
        }
    }

    private fun setUpDetail() {
        var authors = ""
        var image: String? = ""
        var desc: String? = ""
        var title: String? = ""
        if (intentData != null){
            rating = (intentData?.volumeInfo?.averageRating
                ?: (1..9).random()).toString() + "." + (intentData?.volumeInfo?.averageRating
                ?: (1..9).random()).toString()
            if (intentData?.volumeInfo?.authors != null) {
                authors = intentData!!.volumeInfo?.authors?.joinToString(", ") ?: ""
            } else {
                authors = "-"
            }
            if (intentData?.volumeInfo?.imageLinks?.large != null) {
                image = intentData?.volumeInfo!!.imageLinks?.large
            } else {
                image = intentData?.volumeInfo?.imageLinks?.thumbnail
            }
            desc = intentData?.volumeInfo?.description
            title = intentData?.volumeInfo?.title
        } else {
            binding.btnFavorite.isChecked = true
            rating = intentBookmark?.rating ?: "0.0"
            if (intentBookmark?.author != null) {
                authors = intentBookmark!!.author
            } else {
                authors = "-"
            }
            image = intentBookmark?.imageUrl
            desc = intentBookmark?.description
            title = intentBookmark?.title
        }


        binding.apply {
            tvBookTitle.text = title
            tvDescBook.text = desc
            tvBookAuthor.text = authors
            tvBookRating.text = rating

            Glide.with(this@DetailBookActivity)
                .load(image)
                .apply(RequestOptions())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH)
                .into(imgBookDetail)

            cvBookCover.setCardBackgroundColor(HelperFunction.generateRandomColor())

            btnBack.setOnClickListener {
                finish()
            }
        }

    }

    private fun saveRecentViewedBook(id: String) {
        viewModel.saveRecentBookId(id)
    }*/
}