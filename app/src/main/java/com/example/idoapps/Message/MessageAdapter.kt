package com.example.idoapps.Message

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import com.example.idoapps.R
import com.example.idoapps.databinding.ItemMessageBinding
import com.google.android.material.snackbar.Snackbar

class MessageAdapter(
    context: Context,
    private val Messages: List<MessageModel>
) : ArrayAdapter<MessageModel>(context, 0, Messages) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding: ItemMessageBinding = ItemMessageBinding.inflate(LayoutInflater.from(context), parent, false)
        val view = binding.root

        // Mengambil data pada posisi saat ini
        val data = Messages[position]

        // Menggunakan Glide dengan penanganan PNG default (avatar_default.png)
        Glide.with(context)
            .load(data.avatarUrl)
            .placeholder(R.drawable.avatar_default) // Tampil saat loading
            .error(R.drawable.avatar_default)       // Tampil jika URL error/kosong
            .circleCrop()                           // Membuat avatar bulat
            .into(binding.avatarImg)

        binding.textSender.text = data.senderName
        binding.textMessage.text = data.messageText

        view.setOnClickListener {
            Snackbar.make(
                parent,
                "Pesan dari ${data.senderName}: ${data.messageText}",
                Snackbar.LENGTH_SHORT
            ).show()
        }

        return view
    }
}
