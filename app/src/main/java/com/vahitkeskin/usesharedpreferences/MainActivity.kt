package com.vahitkeskin.usesharedpreferences

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.vahitkeskin.usesharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //TODO: SharedPreferences tanımlanıyor
        //TODO: ilk parametre proje paketi (this.packageName veya "com.vahitkeskin.usesharedpreferences")
        //TODO: ikinci parametre sadece bu proje içerisinde yönetilsin diye (MODE_PRIVATE)
        val sharedPreferences = getSharedPreferences(this.packageName, MODE_PRIVATE)

        val edit = sharedPreferences.edit() //TODO: Güncelleme yapacağımız için edit tanımlandı.

        //TODO: Butona tıklama aksitonu
        binding.btnSaved.setOnClickListener {
            //TODO: Kullanıcıdan alınan değer "text" key'i ile kaydedildi
            edit.putString("text", binding.etInput.text.toString()).apply()

            //TODO: Kaydet işlemi yapılır yapılmaz TextView'da tetiklensin.
            binding.tvOutput.text = sharedPreferences.getString("text", "")
        }

        //TODO: Uygulama her açıldığında kayıtlı "text" değeri varsa gösterilsin.
        binding.tvOutput.text = sharedPreferences.getString("text", "")

    }
}