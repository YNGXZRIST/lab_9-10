package ru.kulagin.lab9_10.ui.cakelist.adapter

import android.app.Application
import android.os.Bundle
import androidx.lifecycle.AndroidViewModel
import ru.kulagin.lab9_10.common.App
import ru.kulagin.lab9_10.domain.model.Cake
import ru.kulagin.lab9_10.ui.detail.CakeDetailFragment

class CakeVM(application: Application, val cake: Cake) : AndroidViewModel(application) {
    fun onClick(){
        val cakeDetailFragment = CakeDetailFragment()
        val bundle = Bundle()
        bundle.putLong("ARG_CAKE_ID", cake.id ?: 1)
        cakeDetailFragment.arguments = bundle
        getApplication<App>().mainRouter.changeMainFragment(cakeDetailFragment)
    }
}