package uz.ilkhomkhuja.mvcexampleproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import uz.ilkhomkhuja.mvcexampleproject.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity(), Observer, View.OnClickListener {

    lateinit var binding: ActivityMainBinding
    var model: Model? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        model = Model()
        model?.addObserver(this)

        binding.button.setOnClickListener(this)
        binding.button2.setOnClickListener(this)
        binding.button3.setOnClickListener(this)
    }

    override fun update(observable: Observable?, p1: Any?) {
        binding.button.text = "Count: " + model?.getValueAtIndex(0)
        binding.button2.text = "Count: " + model?.getValueAtIndex(1)
        binding.button3.text = "Count: " + model?.getValueAtIndex(2)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.button -> model?.setValueAtIndex(0)
            R.id.button2 -> model?.setValueAtIndex(1)
            R.id.button3 -> model?.setValueAtIndex(2)
        }
    }
}