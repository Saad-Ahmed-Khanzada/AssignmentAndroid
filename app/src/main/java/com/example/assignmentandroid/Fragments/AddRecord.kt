package com.example.assignmentandroid.Fragments

import DBHandler
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.assignmentandroid.R


class   AddRecord : Fragment()
{

    lateinit var Btn: Button
    lateinit var Et: EditText
    private var dbHandler: DBHandler? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View=inflater.inflate(R.layout.fragment_add_record, container, false)
        Btn= view.findViewById(R.id.button)
        Et= view.findViewById(R.id.editTxt)
        dbHandler = DBHandler(requireContext())

        Btn.setOnClickListener()
        {
            val data=Et.text
            if (data.isEmpty()){
                Toast.makeText(requireContext(), "Field is Empty", Toast.LENGTH_SHORT).show()
            }
            else {
                val text = data
                val duration = Toast.LENGTH_SHORT

                val toast = Toast.makeText(requireContext(), text, duration)
                toast.show()
                dbHandler!!.addData(text.toString())
            }
            }
        return view

    }
}

