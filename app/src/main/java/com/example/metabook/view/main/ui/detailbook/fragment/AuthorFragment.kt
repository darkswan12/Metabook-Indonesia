package com.example.metabook.view.main.ui.detailbook.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.metabook.R


class AuthorFragment : Fragment() {

    //private var pdfbinding: FragmentAuthorBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_author, container, false)

    }

}
