package br.com.zup.simcitysaojoao.home.detalhe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import br.com.zup.simcitysaojoao.databinding.FragmentDetailBinding
import br.com.zup.simcitysaojoao.home.model.Produto
import br.com.zup.simcitysaojoao.home.produto.ProdutoActivity

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val produto = arguments?.getParcelable<Produto>("PRODUTO")
        if (produto != null) {
            binding.tvnomeitem.text = produto.getName()
            binding.tvquantidade.text = "Quantidade:${produto.getquant()}"
            binding.tvvalorunit.text = "Valor Unitário:${produto.getvaloruni()}"
            binding.tvreceita.text = "Receita: ${produto.getdescricao()}"
            binding.ivfavoritar.setOnClickListener {
                Toast.makeText(context, "Produto Favoritado", Toast.LENGTH_SHORT).show()
            }
        }

        (activity as ProdutoActivity).supportActionBar?.title="Detalhe do Produto"

    }

}