package br.com.zup.simcitysaojoao.home.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

class Produto(

    private var produtoName: String,
    private var produtoquant: Int,
    private var produtovaloruni: Double,
    private var produtodescricao: String

) : Parcelable {

    fun getName() = this.produtoName
    fun getdescricao() = this.produtodescricao
    fun getquant() = this.produtoquant
    fun getvaloruni() = this.produtovaloruni


}

