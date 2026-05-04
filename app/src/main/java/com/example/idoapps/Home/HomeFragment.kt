package com.example.idoapps.Home

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.idoapps.AuthActivity
import com.example.idoapps.Home.pertemuan_2.SecondActivity
import com.example.idoapps.Home.pertemuan_3.ThirdActivity
import com.example.idoapps.Home.pertemuan_4.FourthActivity
import com.example.idoapps.Home.pertemuan_5.FifthActivity
import com.example.idoapps.Home.pertemuan_5.WebViewActivity
import com.example.idoapps.Home.pertemuan_7.SevenActivity
import com.example.idoapps.Home.pertemuan_9.NinthActivity
import com.example.idoapps.R
import com.example.idoapps.databinding.FragmentHomeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Home"
        }

        val sharedPref = requireContext().getSharedPreferences("user_pref", MODE_PRIVATE)

        binding.btnToSecond.setOnClickListener {
            val intent = Intent(requireContext(), SecondActivity::class.java)
            startActivity(intent)
        }

            binding.btnToThird.setOnClickListener {
                val intent = Intent(requireContext(), ThirdActivity::class.java)
                startActivity(intent)
            }

            binding.btnToFourth.setOnClickListener {
                val intent = Intent(requireContext(), FourthActivity::class.java)
                intent.putExtra("name", "Politeknik Caltex Riau")
                intent.putExtra("from", "Rumbai")
                intent.putExtra("age", 25)
                startActivity(intent)
            }

            binding.btnToFifth.setOnClickListener {
                val intent = Intent(requireContext(), FifthActivity::class.java)
                startActivity(intent)
            }

            binding.btnToSeven.setOnClickListener {
                val intent = Intent(requireContext(), SevenActivity::class.java)
                startActivity(intent)
            }

            binding.btnToNinth.setOnClickListener {
                val intent = Intent(requireContext(), NinthActivity::class.java)
                startActivity(intent)
            }

            binding.btnWebView.setOnClickListener {
                val intent = Intent(requireContext(), WebViewActivity::class.java)
                startActivity(intent)
            }

            binding.btnLogout.setOnClickListener {
                MaterialAlertDialogBuilder(requireContext())
                    .setTitle("Konfirmasi")
                    .setMessage("Apakah Anda yakin ingin logout?")
                    .setPositiveButton("Ya") { dialog, _ ->
                        dialog.dismiss()
                        val editor = sharedPref.edit()
                        editor.clear()
                        editor.apply()

                        val intent = Intent(requireContext(), AuthActivity::class.java)
                        startActivity(intent)
                        requireActivity().finish()
                    }
                    .setNegativeButton("Batal") { dialog, _ ->
                        dialog.dismiss()
                        Toast.makeText(requireContext(), "Anda Memilih Untuk Tidak Logout", Toast.LENGTH_SHORT)
                            .show()
                        Log.e("Info Dialog", "Anda memilih Tidak!")
                    }
                    .show()
            }
        }
    }

