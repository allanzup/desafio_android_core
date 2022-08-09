package br.com.zup.simcitysaojoao.home.produto.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.simcitysaojoao.databinding.ProdutoItemBinding
import br.com.zup.simcitysaojoao.home.model.Produto

class ProdutoAdapter(
    private var listaProduto: MutableList<Produto>,
    private val clickProduto: (produto: Produto) -> Unit
) : RecyclerView.Adapter<ProdutoAdapter.ViewHolder>() {
    class ViewHolder(val binding: ProdutoItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun exibirdadositemlista(produto: Produto) {
            binding.tvdetalheProduto.text =
                "Nome: ${produto.getName()}  -Quantidade: ${produto.getquant()}"
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ProdutoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = listaProduto[position]
        holder.exibirdadositemlista(produto)
        holder.binding.cvprodut.setOnClickListener {
            clickProduto(produto)
        }
    }

    override fun getItemCount(): Int = listaProduto.size
    fun atualizarListaProduto(novaListaProduto: MutableList<Produto>) {
       listaProduto=novaListaProduto
        if (listaProduto.size == 0) {
            listaProduto = novaListaProduto
        }
        else {
            listaProduto.addAll(novaListaProduto)
        }
        notifyDataSetChanged()
    }

}