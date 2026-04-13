package com.example.idoapps.pertemuan_5

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.idoapps.R
import com.example.idoapps.databinding.ActivityFifthBinding
import com.example.idoapps.databinding.ActivityFourthBinding
import java.util.Calendar

class FifthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFifthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFifthBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // IMPROVISASI: Logika untuk mendapatkan waktu saat ini
        val calendar = Calendar.getInstance()
        val hourOfDay = calendar.get(Calendar.HOUR_OF_DAY)

        // Menentukan sapaan berdasarkan jam
        val greetingSubtitle = when (hourOfDay) {
            in 0..11 -> "Selamat Pagi! 🌅"
            in 12..15 -> "Selamat Siang! ☀️"
            in 16..18 -> "Selamat Sore! 🌇"
            else -> "Selamat Malam! 🌙"
        }

        setSupportActionBar(binding.toolbar)

        supportActionBar?.apply {
            title = "Activity Fifth"
            subtitle = greetingSubtitle
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        binding.btnWebView.setOnClickListener {
            val intent = Intent(this, WebViewActivity::class.java)
            startActivity(intent)
        }

        // IMPROVISASI: Menangkap pergerakan scroll dari NestedScrollView
        binding.nestedScrollView.setOnScrollChangeListener { _, _, scrollY, _, oldScrollY ->
            // Jika user scroll ke bawah lebih dari 500 pixel, tampilkan tombol
            if (scrollY > 500) {
                binding.fabToTop.show()
            }
            // Jika user kembali ke atas (kurang dari 500 pixel), sembunyikan tombol
            else {
                binding.fabToTop.hide()
            }
        }

        // Memberikan aksi pada tombol untuk kembali ke atas
        binding.fabToTop.setOnClickListener {
            // Scroll kembali ke titik 0,0 (paling atas) secara mulus
            binding.nestedScrollView.smoothScrollTo(0, 0)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }
            R.id.action_search -> {
                Toast.makeText(this, "Search diklik", Toast.LENGTH_SHORT).show()
                true
            }

            // IMPROVISASI: Logika untuk menangkap klik dan mengubah status Checkbox
            R.id.action_notif -> {
                item.isChecked = !item.isChecked // Membalikkan status (dari false ke true, atau sebaliknya)
                val status = if (item.isChecked) "Aktif" else "Nonaktif"
                Toast.makeText(this, "Notifikasi $status", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.action_settings -> {
                Toast.makeText(this, "Settings diklik", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }



}