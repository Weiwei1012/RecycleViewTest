package com.cooking.recycleviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.cooking.recycleviewtest.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    private lateinit var actionBar: ActionBar

    private lateinit var itemList: ArrayList<ModelItem>
    private var positionClicked: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        actionBar = supportActionBar!!

        actionBar.setDisplayShowHomeEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)

        itemList = intent.getSerializableExtra("items") as ArrayList<ModelItem>
        positionClicked = intent.getIntExtra("position",0)

        binding.titleTv.text = itemList[positionClicked].title
        binding.descriptionTv.text = itemList[positionClicked].desciption
        binding.iconTv.setImageResource(itemList[positionClicked].image)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}