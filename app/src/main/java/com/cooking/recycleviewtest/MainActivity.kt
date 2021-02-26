package com.cooking.recycleviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.cooking.recycleviewtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding


    private val titles = arrayOf(
        "Easy1",
        "Easy2",
        "Easy3",
        "Easy4",
        "Easy5",
        "Easy6",
        "Easy7"
    )

    private val descriptions = arrayOf(
        "So good",
        "Soo good",
        "Sooo good",
        "Soooo good",
        "Sooooo good",
        "Soooooo good",
        "Sooooooo good"

    )

    private val images = arrayOf(
        R.drawable.easy1,
        R.drawable.easy2,
        R.drawable.easy3,
        R.drawable.easy4,
        R.drawable.easy5,
        R.drawable.easy6,
        R.drawable.easy7
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        loadRecycleViewItems()
    }

    private fun loadRecycleViewItems() {
        //val linearLayoutManager = LinearLayoutManager(this)
        //val gridLayoutManager = GridLayoutManager(this,2)
        val staggeredGridLayoutManager = StaggeredGridLayoutManager(2,1)

        binding.itemsRV.layoutManager = staggeredGridLayoutManager

        val itemList:ArrayList<ModelItem> = ArrayList()

        for (i in titles.indices){
            val model = ModelItem(titles[i], descriptions[i], images[i])

            itemList.add(model)
        }

        val adapterItem = AdapterItem(this,itemList)

        binding.itemsRV.adapter = adapterItem
    }
}