package ru.kulagin.lab9_10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.kulagin.lab9_10.common.App
import ru.kulagin.lab9_10.data.repository.StoreRepositoryNet
import ru.kulagin.lab9_10.databinding.ActivityMainBinding
import ru.kulagin.lab9_10.ui.cakelist.CakesFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (applicationContext as App).mainRouter = MainRouter(supportFragmentManager)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        supportFragmentManager.beginTransaction().replace(R.id.full_content, CakesFragment()).commit()
    }
}