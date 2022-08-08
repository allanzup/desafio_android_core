package br.com.zup.simcitysaojoao.home.total

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import br.com.zup.simcitysaojoao.R
import br.com.zup.simcitysaojoao.databinding.FragmentTotalBinding
import br.com.zup.simcitysaojoao.home.model.Produto

class TotalFragment : Fragment() {
    private lateinit var binding: FragmentTotalBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTotalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val totalproduto = arguments?.getParcelableArrayList<Produto>("LISTA_DE_PRODUTO")
        var somatotal = 0.0
        totalproduto?.forEach {
            somatotal += it.getquant() * it.getvaloruni()
        }
        binding.tvdescvalortot.text="O Valor total de todos os produtos é de ${somatotal}"
        binding.bcadastProdu.setOnClickListener {
            val bundle= bundleOf("LISTA_PRODUTO" to totalproduto  )
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_totalFragment_to_produto_Fragment,bundle)

        }
    }

}