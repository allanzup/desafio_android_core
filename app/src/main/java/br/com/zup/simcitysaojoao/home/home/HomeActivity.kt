package br.com.zup.simcitysaojoao.home.home

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import br.com.zup.simcitysaojoao.R
import br.com.zup.simcitysaojoao.home.produto.ProdutoActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val btnCadastro = findViewById<Button>(R.id.btnCadastro)
        btnCadastro.setOnClickListener {
            startActivity(Intent(this, ProdutoActivity::class.java))
        }
    }
}