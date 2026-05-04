package com.example.idoapps.More

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.idoapps.databinding.FragmentMoreBinding

class FragmentMore : Fragment() {

    private var _binding: FragmentMoreBinding? = null
    private val binding get() = _binding!!

    private val dataList = listOf(
        "Kotlin", "Java", "Python", "C++", "JavaScript", "Dart", "Swift", "Go", "Ruby", "R",
        "PHP", "C#", "TypeScript", "Shell", "SQL", "Perl", "Rust", "Scala", "Haskell", "Lua",
        "Erlang", "Prolog", "Assembly", "Objective-C", "VBA"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup Toolbar
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "More"
        }

        /* Definisikan adapter sebagai penghubung dataList dengan layout simple_list_item_1 */
        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            dataList
        )

        // Hubungkan listViewItems dengan adapter
        binding.listViewItems.adapter = adapter

        // Tambahkan aksi saat item di-list diklik
        binding.listViewItems.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = dataList[position]
            Toast.makeText(requireContext(), "Kamu memilih: $selectedItem", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
