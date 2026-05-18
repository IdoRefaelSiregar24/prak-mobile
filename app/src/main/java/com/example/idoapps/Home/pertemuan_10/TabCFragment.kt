package com.example.idoapps.Home.pertemuan_10

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.idoapps.databinding.FragmentTabCBinding

class TabCFragment : Fragment() {

    private var _binding: FragmentTabCBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Gunakan FragmentTabCBinding bukan ActivityTenthBinding
        _binding = FragmentTabCBinding.inflate(inflater, container, false)
        return binding.root
    }

    private val productList = listOf(
        ProductModel("Sepatu Running Nike", "Rp 850.000", "https://picsum.photos/seed/shoe1/400/300"),
        ProductModel("Kemeja Flannel", "Rp 320.000", "https://picsum.photos/seed/shirt1/400/300"),
        ProductModel("Tas Ransel Laptop", "Rp 450.000", "https://picsum.photos/seed/bag1/400/300"),
        ProductModel("Jam Tangan Casio", "Rp 1.200.000", "https://picsum.photos/seed/watch1/400/300"),
        ProductModel("Headphone Sony", "Rp 1.500.000", "https://picsum.photos/seed/audio1/400/300"),
        ProductModel("Kaos Polos Premium", "Rp 150.000", "https://picsum.photos/seed/tshirt1/400/300"),
        ProductModel("Celana Jogger", "Rp 280.000", "https://picsum.photos/seed/pants1/400/300"),
        ProductModel("Sneakers Adidas", "Rp 950.000", "https://picsum.photos/seed/shoe2/400/300"),
        ProductModel("Dompet Kulit", "Rp 220.000", "https://picsum.photos/seed/wallet1/400/300"),
        ProductModel("Topi Baseball", "Rp 120.000", "https://picsum.photos/seed/hat1/400/300"),
        ProductModel("Mouse Gaming RGB", "Rp 275.000", "https://picsum.photos/seed/mouse1/400/300"),
        ProductModel("Keyboard Mechanical", "Rp 780.000", "https://picsum.photos/seed/keyboard1/400/300"),
        ProductModel("Monitor LG 24 Inch", "Rp 2.100.000", "https://picsum.photos/seed/monitor1/400/300"),
        ProductModel("Power Bank 20000mAh", "Rp 350.000", "https://picsum.photos/seed/powerbank1/400/300"),
        ProductModel("Charger Fast Charging", "Rp 180.000", "https://picsum.photos/seed/charger1/400/300")
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ProductAdapter(productList) { selectedItem ->
            Toast.makeText(requireContext(), "Anda memilih ${selectedItem.name}", Toast.LENGTH_SHORT).show()
        }

        binding.rvProducts.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            this.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}