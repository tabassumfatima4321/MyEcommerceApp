package com.dawaai.myecommerceapp.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dawaai.myecommerceapp.model.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ProductViewModel  @Inject constructor(private val repository: ProductRepository):
    ViewModel()  {
    val data: LiveData< Response<List<Product>>>
        get() = _data
    private val _data = MutableLiveData<Response<List<Product>>>()

    fun getProducts() {
       CoroutineScope(Dispatchers.IO).launch {
           val response = repository.getProducts()
           withContext(Dispatchers.Main) {
               _data.postValue(response)
           }
        }
    }


}