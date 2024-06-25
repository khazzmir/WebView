package com.example.webview

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.webview.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sessionManager = SessionManager(this)

        binding.btnLogin.setOnClickListener {
            val name = binding.edtName.text.toString()
            val email = binding.edtEmail.text.toString()

            // validasi form
            if (name.isEmpty()) {
                binding.edtName.error = "Harap isi nama"
                return@setOnClickListener
            }

            if (email.isEmpty()) {
                binding.edtEmail.error = "Harap isi email"
                return@setOnClickListener
            }

            // validasi input
            if (name == "a" && email == "a@gmail.com") {
                // simpan sesi login
                sessionManager.sessionLogin(name, email)

                // berpindah halaman
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Nama / email salah", Toast.LENGTH_SHORT).show()
            }
        }
    }
}