package com.example.autocomplatetextview

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.autocomplatetextview.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //khai bao list
        val list = resources.getStringArray(R.array.province)
        val adt = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)

        binding.autoProvince.setAdapter(adt)

        //goi y
        binding.autoProvince.setOnFocusChangeListener(View.OnFocusChangeListener { v, hasFocus ->
            if(hasFocus){
                binding.autoProvince.showDropDown()
            }

        })
//        binding.autoProvince.setOnClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->
//            Toast.makeText(this,"Click Item"+ list[position], Toast.LENGTH_SHORT).show() )
//        })
        binding.autoProvince.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "Click Item " + binding.autoProvince.text.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}