package com.nino.samplelistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.nino.samplelistapp.SampleListAdapter.*
import com.nino.samplelistapp.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var sampleListAdapter: SampleListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvList.apply {
            sampleListAdapter = SampleListAdapter()
            adapter = sampleListAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
        }

        sampleListAdapter?.items = generateRandomItems(10)
    }

    private fun generateRandomItems(numItems: Int): List<Item> {
        val items = mutableListOf<Item>()

        val itemNames = listOf("Book", "Shirt", "Phone", "Headphones", "Watch", "Camera", "Shoes", "Backpack", "Guitar", "Laptop")

        for (i in 1..numItems) {
            val randomName = itemNames.random()
            val randomPrice = Random.nextDouble(1.0, 100.0)
            val item = Item(randomName, randomPrice)
            items.add(item)
        }
        val total: Double = items.sumOf { it.price }
        items.add(Item(name = "Total", price = total))

        return items
    }
}