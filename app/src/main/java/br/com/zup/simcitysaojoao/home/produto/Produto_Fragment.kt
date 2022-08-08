package br.com.zup.simcitysaojoao.home.produto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import br.com.zup.simcitysaojoao.R
import br.com.zup.simcitysaojoao.databinding.FragmentProdutoBinding
import br.com.zup.simcitysaojoao.home.model.Produto

class Produto_Fragment : Fragment() {
    private lateinit var binding: FragmentProdutoBinding
    private var listaProduto = ArrayList<Produto>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProdutoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCadrastroProduto.setOnClickListener {
            val listaProdutBundle=recebeListaProduto()
            if (listaProdutBundle!=null){
                listaProduto.addAll(listaProdutBundle)
            }
            val nomeProduto = binding.etNomeProduto.text.toString()
            val quantProduto = binding.etQuantProduto.text.toString()
            val valorUnProduto = binding.etValorUnitProduto.text.toString()
            val receita = binding.etReceitaProduto.text.toString()
            if (nomeProduto.isNotBlank() && quantProduto.isNotBlank() && valorUnProduto.isNotBlank()
                && receita.isNotBlank()
            ) {
                listaProduto.add(
                    Produto(
                        nomeProduto,
                        quantProduto.toInt(),
                        valorUnProduto.toDouble(),
                        receita
                    )
                )
                binding.etNomeProduto.text.clear()
                binding.etQuantProduto.text.clear()
                binding.etReceitaProduto.text.clear()
                binding.etValorUnitProduto.text.clear()
            } else {
                binding.etNomeProduto.error = "Campo em branco, preencha corretamente os dados"
                binding.etQuantProduto.error = "Campo em branco, preencha corretamente os dados"
                binding.etValorUnitProduto.error = "Campo em branco, preencha corretamente os dados"
                binding.etReceitaProduto.error = "Campo em branco, preencha corretamente os dados"
            }

        }

        binding.btnverProduto.setOnClickListener {
            val bundle = bundleOf("LISTA_DE_PRODUTO" to listaProduto)
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_produto_Fragment_to_detalheFragment, bundle)
        }
        binding.btnvalottotal.setOnClickListener {
            val bundle = bundleOf("LISTA_DE_PRODUTO" to listaProduto)
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_produto_Fragment_to_totalFragment, bundle)
        }
    }

    private fun recebeListaProduto(): ArrayList<Produto>? {
        return arguments?.getParcelableArrayList<Produto>("LISTA_PRODUTO")
    }

}
