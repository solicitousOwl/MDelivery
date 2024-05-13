package com.example.fooddelivery.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fooddelivery.R
import com.example.fooddelivery.adapters.PopularAdapter
import com.example.fooddelivery.databinding.FragmentSearchBinding
import com.example.fooddelivery.models.PopularModel
import com.example.fooddelivery.models.SharedModel

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter: PopularAdapter
    private lateinit var list: ArrayList<PopularModel>
    private lateinit var sharedModel: SharedModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater, container, false)

        sharedModel = ViewModelProvider(requireActivity()).get(SharedModel::class.java)

        list = ArrayList()
        list.add(PopularModel(R.drawable.pop_menu_burger, "Sandwich",7, 7,1))
        list.add(PopularModel(R.drawable.pop_menu_sandwich, "Momo",9, 9,1))
        list.add(PopularModel(R.drawable.pop_menu_momo, "Burger",5, 5,1))
        list.add(PopularModel(R.drawable.pop_menu_burger, "Sandwich",7, 7,1))
        list.add(PopularModel(R.drawable.pop_menu_sandwich, "Momo",9, 9,1))
        list.add(PopularModel(R.drawable.pop_menu_momo, "Burger",5, 5,1))
        list.add(PopularModel(R.drawable.pop_menu_burger, "Sandwich",7, 7,1))
        list.add(PopularModel(R.drawable.pop_menu_sandwich, "Momo",9, 9,1))
        list.add(PopularModel(R.drawable.pop_menu_momo, "Burger",5, 5,1))
        list.add(PopularModel(R.drawable.pop_menu_burger, "Sandwich",7, 7,1))
        list.add(PopularModel(R.drawable.pop_menu_sandwich, "Momo",9, 9,1))
        list.add(PopularModel(R.drawable.pop_menu_momo, "Burger",5, 5,1))


        // !!!!!!!!!!!!!!!Разобрать работу контекста и конструктора !!!!!
        adapter = PopularAdapter(requireContext(), list)
        adapter.setSharedModel(sharedModel)

        binding.searchMenuRv.layoutManager = LinearLayoutManager(requireContext())
        binding.searchMenuRv.adapter = adapter

        searchMenuFood()
        return binding.root
    }

    private fun searchMenuFood() {
        binding.searchMenuItem.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                filterList(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }
        })
    }

    // сортировка в поисковой строке
    private fun filterList (input: String?) {
        val filteredList = if (input.isNullOrEmpty()){
            list
        }else{
            list.filter { item ->
                item.getFoodName().contains(input, ignoreCase = true)
            }
        }
        adapter.updateList(filteredList as ArrayList<PopularModel>)
    }
}