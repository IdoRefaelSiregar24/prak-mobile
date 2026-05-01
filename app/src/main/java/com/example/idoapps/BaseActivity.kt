package com.example.idoapps

import android.os.Bundle
import android.widget.Toast
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.idoapps.Home.HomeFragment
import com.example.idoapps.Message.MessageFragment
import com.example.idoapps.More.MoreFragment
import com.example.idoapps.databinding.ActivityBaseBinding

class BaseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup Toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Ido Apps"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }

        // Tampilkan fragment pertama kali tanpa masuk ke backstack
        if (savedInstanceState == null) {
            replaceFragment(HomeFragment(), false)
        }

        binding.bottomNavView.setOnItemSelectedListener {

            supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)

            when (it.itemId) {
                R.id.home -> {
                    replaceFragment(HomeFragment(), false)
                    true
                }
                R.id.message -> {
                    replaceFragment(MessageFragment(), false)
                    true
                }
                R.id.more -> {
                    replaceFragment(MoreFragment(), false)
                    true
                }
                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment, addToBackStack: Boolean = true) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(binding.fragmentContainer.id, fragment)

        // Solusi: Hanya tambahkan ke backstack jika bukan fragment pertama atau jika diinginkan
        if (addToBackStack) {
            transaction.addToBackStack(null)
        }

        transaction.commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                if (supportFragmentManager.backStackEntryCount > 0) {
                    supportFragmentManager.popBackStack()
                } else {
                    onBackPressedDispatcher.onBackPressed()
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}