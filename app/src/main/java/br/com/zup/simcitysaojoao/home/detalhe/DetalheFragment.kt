package br.com.zup.simcitysaojoao.home.detalhe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.zup.simcitysaojoao.databinding.FragmentListaProdutoBinding
import br.com.zup.simcitysaojoao.home.model.Produto
import br.com.zup.simcitysaojoao.home.produto.adapter.ProdutoAdapter


class DetalheFragment : Fragment() {
    private lateinit var binding: FragmentListaProdutoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListaProdutoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listaproduto = arguments?.getParcelableArrayList<Produto>("LISTA_DE_PRODUTO")
        if (listaproduto != null) {
            binding.rvlistaProduto.adapter = ProdutoAdapter(listaproduto,this::goToDetail)
            binding.rvlistaProduto.layoutManager = LinearLayoutManager(context)
        }
    }
    fun onClick(produto:Produto) {
        val bundle = bundleOf("PRODUTO" to produto)
        NavHostFragment.findNavController(this)
            .navigate(R.id.action_produtosCadastrados2_to_detalheProdutoFragment,bundle)
    }
}