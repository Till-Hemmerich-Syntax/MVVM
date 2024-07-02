package com.syntax.hemmerich.batch17_mvvm.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.syntax.hemmerich.batch17_mvvm.data.Repository
import com.syntax.hemmerich.batch17_mvvm.data.model.Plane

class HomeViewModel : ViewModel(){

    private var repository = Repository()
    private var planes = repository.planeList
    private var position = 0



    private var _currentPlane = MutableLiveData<Plane>(planes[position])
    val currentPlane : LiveData<Plane>
        get() = _currentPlane

    fun nextPlane(){
        position++
        if(position+1>planes.size){
            position = 0
        }
        _currentPlane.value = planes[position]
    }
    fun prevPlane(){
        position--
        if(position<0){
            position = planes.size-1
        }
        _currentPlane.value = planes[position]
    }
    fun goToFirstPlane(){
        _currentPlane.value = planes[0]
    }
}