package com.example.meliseswita

import android.content.Intent
import android.os.Bundle
import android.widget.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.meliseswita.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
     binding = ActivityMainBinding.inflate(layoutInflater)
     setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)








        var tvsb = findViewById<TextView>(R.id.tvsb)

        var sek = findViewById<SeekBar>(R.id.sek)
        sek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(SeekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                tvsb.text = progress.toString()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

//        variable data data
        val btnkirim = findViewById<Button>(R.id.btnkirim)
        val edi = findViewById<EditText>(R.id.edi)
        val ed2 = findViewById<EditText>(R.id.ed2)
        val ed3 = findViewById<EditText>(R.id.ed3)
        val rimg = findViewById<RadioButton>(R.id.rimg)
        val rb2 = findViewById<RadioButton>(R.id.rb2)
        val sp = findViewById<Spinner>(R.id.sp)

        //proses pengiriman data dengan inten
        btnkirim.setOnClickListener() {
            val tgbt = findViewById<ToggleButton>(R.id.tgbt)
            val rimg = findViewById<RadioButton>(R.id.rimg)
            val rb2 = findViewById<RadioButton>(R.id.rb2)
            val tvps = findViewById<Spinner>(R.id.sp)
            val jurusan = tvps.selectedItem.toString()
            val kelas = if (tgbt.isChecked) "Pagi" else "Sore"
            val umur = tvsb.text.toString()
            val password = ed3.text.toString()
            val email =ed2.text.toString()
            val nama = edi.text.toString()
            val rbPria = findViewById<RadioButton>(R.id.rimg)
            val rbWanita = findViewById<RadioButton>(R.id.rb2)
            val jenisKelamin = if (rbPria.isChecked) {
                "Laki-Laki"
            } else if (rbWanita.isChecked) {
                "Perempuan"
            } else {
                "Belum Dipilih"
            }
            Intent(this, activity_hasil::class.java). also {
                it.putExtra("Extra_Nama", nama)
                it.putExtra("Extra_Email", email)
                it.putExtra("Extra_Pass", password)
                it.putExtra("Extra_Umur", umur)
                it.putExtra("Extra_Kelas", if (tgbt.isChecked) "Pagi" else "Sore")
                it.putExtra("Extra_Jurusan", tvps.selectedItem.toString())
                it.putExtra("EXTRA_JENIS_KELAMIN", jenisKelamin)
                startActivity(it)
            }

        }






    }
}