package com.baubaptest.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.baubaptest.R
import com.baubaptest.databinding.ActivityMainBinding
import com.baubaptest.ui.viewModel.BaubapViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val baubapViewModel:BaubapViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        initListeners()
        initObservers()
        setContentView(binding.root)
    }

    private fun initListeners(){
        binding.apply {
            btnLogin.setOnClickListener {
                baubapViewModel.loginUser()
            }
        }
    }

    private fun initObservers(){
        baubapViewModel.userLogin.observe(this) { login ->
            showErrorDialog()
        }
    }

    private fun showErrorDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(getString(R.string.app_name))
        builder.setMessage(getString(R.string.baubap_test_login_alert_content))
        builder.show()
    }
}