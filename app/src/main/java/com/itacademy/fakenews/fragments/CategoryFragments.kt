package com.itacademy.fakenews.fragments

import android.os.Bundle
import android.provider.SyncStateContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.itacademy.fakenews.R
import com.itacademy.fakenews.adapters.CategoryAdapter
import com.itacademy.fakenews.adapters.CategoryClickListener
import com.itacademy.fakenews.models.CategoryModel
import com.itacademy.fakenews.models.Constants

class CategoryFragments() : Fragment(), CategoryClickListener {

    fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
        adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_category, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.category_recyclerview)
        recyclerView.adapter = CategoryAdapter(Constants.categories, this)
        recyclerView.adapter = adapter

        return view
    }

    override fun categoryClicked(clickedCategory: CategoryModel) {
        val bundle = Bundle()
        bundle.putSerializable("category", clickedCategory)
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.container, NewsFragments::class.java, bundle)
            .addToBackStack(null)
            .commit()

    }
}