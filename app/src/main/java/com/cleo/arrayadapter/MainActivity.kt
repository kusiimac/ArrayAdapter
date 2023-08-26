package com.cleo.arrayadapter

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.cleo.arrayadapter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val myList = binding.myList
        val countryList = listOf("Uganda", "Kenya", "Tanzania", "Rwanda", "Burundi",
            "South Sudan", "Germany", "Canada", "China", "Argentina", "Brazil", "France")
        val cityList = listOf("Kampala", "Nairobi", "Dar es salaam", "Kigali", "Bujumbura",
            "Juba", "Berlin", "Ottawa", "Beijing", "Buenos Aires", "Brasilia", "Paris" )

//        val arrayAdapter = ArrayAdapter(this, R.layout.list_item_layout, R.id.country_id,countryList)
//        myList.adapter = arrayAdapter

        val arrayAdapter = MyAdapter(this, countryList, cityList)
        myList.adapter = arrayAdapter
    }
}

class MyAdapter(context: Context, val countryList: List<String>, val cityList: List<String>):
    ArrayAdapter<String>(context,R.layout.list_item_layout,R.id.country_id,cityList ) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getView(position, convertView, parent)

        val countryId = view.findViewById<TextView>(R.id.country_id)
        val cityId = view.findViewById<TextView>(R.id.city_id)

        countryId.text = countryList[position]
        cityId.text = cityList[position]

        return view
    }
}