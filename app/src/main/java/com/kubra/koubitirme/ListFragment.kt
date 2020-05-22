package com.kubra.koubitirme

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_list_fragment.*

class ListFragment : Fragment() {

    private lateinit var viewModel : ViewModel
    private val animalAdapter = AnimalAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_list_fragment,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel =ViewModelProviders.of(this).get(ViewModel::class.java)
        viewModel.refreshData()
        listAnimal.layoutManager = LinearLayoutManager(context)
        listAnimal.adapter=animalAdapter

        observeLiveData()

    }

    fun observeLiveData(){
        viewModel.animals.observe(viewLifecycleOwner, Observer {animals ->
            animals?.let {
                listAnimal.visibility =View.VISIBLE
                animalAdapter.updateAnimalList(animals)
            }
        })

        viewModel.animalError.observe(viewLifecycleOwner, Observer {error ->
            error?.let {
                if(it){
                    animalError.visibility=View.VISIBLE
                }else{
                    animalError.visibility=View.GONE
                }
            }
        })

        viewModel.animalLoading.observe(viewLifecycleOwner,Observer{ loading ->
            loading?.let {
                if(it){
                    animalLoading.visibility=View.VISIBLE
                    listAnimal.visibility=View.GONE
                    animalError.visibility=View.GONE
                }else{
                    animalLoading.visibility = View.GONE
                }
            }
        })

    }
}
