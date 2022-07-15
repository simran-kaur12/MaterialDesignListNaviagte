package com.example.a13julytask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a13julytask.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationBarView


class MainActivity : AppCompatActivity(),MyAdapter.OnItemClickListener {
    private lateinit var binding: ActivityMainBinding
    private var number = Array(50){ i: Int -> i * 1 }
    private lateinit var user :ArrayList<Value>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Recycler View Work
        binding.re.layoutManager = LinearLayoutManager(this)
        binding.re.setHasFixedSize(true)
        //Works end here
        NavigationBarView.OnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.page_1 -> {
                    true
                }
                R.id.page_2 -> {
                    true
                }
                R.id.page_3 -> {
                    true
                }
                R.id.page_4 -> {
                    true
                }
                else -> false
            }
        }
        user = arrayListOf()
        getUserData()
    }

    private fun getUserData() {
        for (i in number.indices){
            val userNum = Value("User "+(number[i]+1).toString())
            user.add(userNum)
        }
        binding.re.adapter = MyAdapter(user,this)
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this,"Item $position Clicked",Toast.LENGTH_SHORT).show()
        binding.re.adapter?.notifyItemChanged(position)
    }

}
