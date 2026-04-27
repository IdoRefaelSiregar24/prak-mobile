package com.example.idoapps.Home.pertemuan_2

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.idoapps.R
import com.example.idoapps.databinding.ActivitySecondBinding
import com.example.idoapps.databinding.ActivityThirdBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        enableEdgeToEdge()
//        setContentView(R.layout.activity_second)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
            // Inisialisasi komponen
//            val inputNama: EditText = findViewById(R.id.inputNama)
//            val btnSubmit: Button = findViewById(R.id.btnSubmit)

            binding.btnSubmit.setOnClickListener {
                //Mengambil value dari inputNama dan menampilkan di Logcat
                val nama = binding.inputNama.text
                Log.e("Klik btnSubmit","Tombol berhasil di tekan. Isi dari inputNama = $nama")

                Toast.makeText(this, "Terima kasih $nama Anda telah melakukan klik pada tombol Submit ", Toast.LENGTH_SHORT).show()

        }
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Activity Second"
            subtitle = "Ini adalah subtitle"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}