package com.example.practical10

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practical10.databinding.PersonItemViewBinding
import java.io.Serializable

class PersonAdapter (private val context: Context, private val array:ArrayList<Person>):
    RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {
    inner class PersonViewHolder(val binding: PersonItemViewBinding): RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val binding = PersonItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PersonViewHolder(binding)
    }
    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        with(holder){
            with(array[position]){
                binding.textViewPhoneNo.text = this.PhoneNo
                binding.textViewName.text = this.Name
                binding.textViewEmail.text = this.EmailId
                binding.textViewAddress.text = this.Address
                val obj = this as Serializable
                binding.buttonMap.setOnClickListener {
                    Intent(this@PersonAdapter.context, MapActivity::class.java).apply {
                        putExtra("Object",obj)
                        this@PersonAdapter.context.startActivity(this)
                    }
                    //Toast.makeText(this@PersonAdapter.context, "Clicked on "+binding.textViewName+", Location: Lat:"+this.Latitude+"Long:"+this.Longitude, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return array.size
    }
}