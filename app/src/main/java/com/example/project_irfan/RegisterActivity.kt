package com.example.project_irfan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.project_irfan.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity:AppCompatActivity() {

    lateinit var binding: FragmentRegisterBinding
    lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = FragmentRegisterBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.btnRegister.setOnClickListener {
            val email = binding.inputEmail.text.toString()
            val password = binding.inputPassword.text.toString()

            //validasi Email
            if (email.isEmpty()){
                binding.inputEmail.error = "Email Harus Diisi"
                binding.inputEmail.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.inputEmail.error = "Email Tidak Valid"
                binding.inputEmail.requestFocus()
                return@setOnClickListener
            }
            //validasi Password
            if (password.isEmpty()){
                binding.inputPassword.error = "Password Harus Diisi"
                binding.inputPassword.requestFocus()
                return@setOnClickListener
            }
            if (password.length < 6){
                binding.inputPassword.error = "Password Minimal 6 Karakter"
                binding.inputPassword.requestFocus()
                return@setOnClickListener
            }

            RegisterFirebase(email,password)
        }
    }

    private fun RegisterFirebase(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener(this) {
                if (it.isSuccessful){
                    Toast.makeText(this, "Register Berhasil", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this,LoginActivity::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }

}