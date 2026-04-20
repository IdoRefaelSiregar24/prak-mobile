package com.example.idoapps.pertemuan_6

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.idoapps.R
import com.example.idoapps.databinding.ActivityAuthBinding
import com.example.idoapps.databinding.ActivityFifthBinding
import com.example.idoapps.pertemuan_3.ThirdActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class AuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val emailDefault = "ido@gmail.com"
        val passwordDefault = "ido"

        binding.btnLogin.setOnClickListener {
            val inputEmail = binding.email.text.toString()
            val inputPassword = binding.Password.text.toString()

            if (inputEmail == emailDefault && inputPassword == passwordDefault) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                MaterialAlertDialogBuilder(this)
                    .setTitle("Gagal Login")
                    .setMessage("Silahkan Coba Lagi")
                    .show()
            }
        }
    }
}