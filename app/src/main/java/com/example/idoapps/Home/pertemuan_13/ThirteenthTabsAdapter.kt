package com.example.idoapps.Home.pertemuan_13

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.idoapps.Home.pertemuan_13.TabCaptureFragment
import com.example.idoapps.Home.pertemuan_13.TabQrcodeFragment
import com.example.idoapps.Home.pertemuan_13.TabScanFragment



class ThirteenthTabsAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {


    override fun getItemCount(): Int = 3
    // Menentukan Fragment mana yang akan ditampilkan berdasarkan posisi tab
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TabScanFragment()
            1 -> TabQrcodeFragment()
            2 -> TabCaptureFragment()
            else -> throw IllegalStateException("Posisi tidak valid")
        }
    }

}