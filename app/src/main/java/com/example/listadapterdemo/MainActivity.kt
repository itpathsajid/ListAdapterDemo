package com.example.listadapterdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listadapterdemo.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.combineTransform

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding : ActivityMainBinding

    private val testAdapter = TestAdapter()
    private var listOfPerson: ArrayList<Person> = ArrayList()
    private var idCount = 4


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.rvTest.layoutManager = LinearLayoutManager(this)
        mBinding.rvTest.adapter = testAdapter
        updateAdapter()

        mBinding.buttonAdd.setOnClickListener {
            val newList : ArrayList<Person> = ArrayList()
            newList.addAll(testAdapter.currentList)
            newList.add(Person(idCount, "React Native $idCount","Test $idCount"))
            testAdapter.submitList(newList)
            idCount++
        }

        mBinding.buttonUpdate.setOnClickListener {
            val newList : ArrayList<Person> = ArrayList()
            newList.addAll(testAdapter.currentList)
            newList[0] = Person(1, "Intern","XYZ")
            testAdapter.submitList(newList)
        }
    }

    private fun updateAdapter() {

        listOfPerson.add(Person(1, "Android","Sajid"))
        listOfPerson.add(Person(2, "DotNet","Ali"))
        listOfPerson.add(Person(3, "PHP","Star"))

        listOfPerson.filter { it.id == 1 }

        testAdapter.submitList(listOfPerson)

    }
}