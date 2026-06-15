package com.example.idoapps.Home.pertemuan_3

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.idoapps.R
import com.example.idoapps.databinding.ActivityThirdBinding
import com.example.idoapps.utils.NotificationHelper
import com.example.idoapps.utils.PermissionHelper

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding

    private val notificationPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                Toast.makeText(this, "Notifikasi diizinkan", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Notifikasi ditolak", Toast.LENGTH_SHORT).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Memeriksa izin notifikasi
        if (PermissionHelper.isNotificationPermissionRequired()) {
            val permission = Manifest.permission.POST_NOTIFICATIONS
            if (!PermissionHelper.hasPermission(this, permission)) {
                PermissionHelper.requestPermission(
                    notificationPermissionLauncher,
                    permission
                )
            }
        }

    //Inisialisasi Secara Manual Tanpa Buinding
//    val btnKirim: Button = findViewById(R.id.btnKirim)
//    val NoTujuan: EditText = findViewById(R.id.inputNoTujuan)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Activity Third"
            subtitle = "Ini adalah subtitle"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

    binding.btnKirim.setOnClickListener {
        val nomor = binding.inputNoTujuan.text
        Toast.makeText(this,"Pesan berhasil di kirim ke $nomor", Toast.LENGTH_SHORT).show()

        val intent = Intent(this, ThirdResultActivity::class.java)
        /// startActivity(intent)

        NotificationHelper.showNotification(
            this, //Jika panggil di fragment maka requireContext()
            "Pesanan Anda",
            "Halo $nomor, Pesanan Anda Sedang Diproses",
            intent
        )
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