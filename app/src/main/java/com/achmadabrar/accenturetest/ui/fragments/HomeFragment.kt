package com.achmadabrar.accenturetest.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.achmadabrar.accenturetest.R
import com.achmadabrar.accenturetest.core.BaseFragment
import com.achmadabrar.accenturetest.data.models.AreaName
import com.achmadabrar.accenturetest.ui.CityAdapter
import com.achmadabrar.accenturetest.ui.CityViewholder
import com.achmadabrar.accenturetest.ui.WeatherViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject


/**
 * Abrar
 */

class HomeFragment : BaseFragment(), CityViewholder.Listener {

    @Inject
    lateinit var viewModel: WeatherViewModel

    var adapter: CityAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(activity!!, viewModelFactory).get(WeatherViewModel::class.java)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.areaLiveData.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                adapter = CityAdapter(this, it)
                loadRecyclerView()
                text_view_not_found.visibility = View.GONE
                recycler_view.visibility = View.VISIBLE
            } else  {
                text_view_not_found.visibility = View.VISIBLE
                recycler_view.visibility = View.GONE
            }
        })

        search_view.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.checkQuery(query)
                val imm = activity!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.checkQuery(newText)
                return true
            }

        })

        search_view.setOnCloseListener(object : SearchView.OnCloseListener{
            override fun onClose(): Boolean {
                viewModel.loadAllCity()
                return true
            }

        })
    }

    fun loadRecyclerView() {
        recycler_view.adapter = adapter
        recycler_view.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }

    override fun onClickArea(areaName: AreaName) {
        viewModel.getCityFromSearch(areaName)
    }

}