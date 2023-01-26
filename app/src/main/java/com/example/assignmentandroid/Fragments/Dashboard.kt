package com.example.assignmentandroid.Fragments

import DBHandler
import android.graphics.drawable.ClipDrawable.VERTICAL
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignmentandroid.AdapterDataClass
import com.example.assignmentandroid.DataModel
import com.example.assignmentandroid.R


class Dashboard : Fragment()
{
    lateinit var courseModalArrayList: ArrayList<DataModel>
    private var dbHandler: DBHandler? = null
    private var courseRVAdapter: AdapterDataClass? = null
    lateinit var RecyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        // Inflate the layout for this fragment
        val view:View= inflater.inflate(R.layout.fragment_dashboard, container, false)

        dbHandler = DBHandler(requireContext());
        RecyclerView= view.findViewById(R.id.recyclerdash)
        courseModalArrayList= ArrayList()

        courseModalArrayList = dbHandler!!.readCourses()

        // on below line passing our array lost to our adapter class.

        // on below line passing our array lost to our adapter class.
        courseRVAdapter = AdapterDataClass(requireContext(), courseModalArrayList)


        // setting layout manager for our recycler view.

        // setting layout manager for our recycler view.
        val linearLayoutManager =
            LinearLayoutManager(requireContext(), androidx.recyclerview.widget.RecyclerView.VERTICAL, false)
       RecyclerView.setLayoutManager(linearLayoutManager)

        // setting our adapter to recycler view.

        // setting our adapter to recycler view.
        RecyclerView.setAdapter(courseRVAdapter)
        return view
    }
}