package com.example.project_irfan
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.project_irfan.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity:AppCompatActivity() {

    lateinit var binding: FragmentLoginBinding
    lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            val intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }

        auth = FirebaseAuth.getInstance()

        binding.btnLogin.setOnClickListener {
            val email = binding.InputEmailLogin.text.toString()
            val password = binding.InputPasswordLogin.text.toString()

            //validasi Email
            if (email.isEmpty()){
                binding.InputEmailLogin.error = "Email Harus Diisi"
                binding.InputEmailLogin.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.InputEmailLogin.error = "Email Tidak Valid"
                binding.InputEmailLogin.requestFocus()
                return@setOnClickListener
            }
            //validasi Password
            if (password.isEmpty()){
                binding.InputPasswordLogin.error = "Password Harus Diisi"
                binding.InputPasswordLogin.requestFocus()
                return@setOnClickListener
            }


            LoginFirebase(email,password)
        }
    }

    private fun LoginFirebase(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {
                if (it.isSuccessful){
                    Toast.makeText(this, "Selamat Datang Balliners", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
}