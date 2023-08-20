package br.com.novare.entities.paginador

interface Paginador {
    fun validaPaginador()

    fun getLimite(): Int

    fun getPagina(): Long
}
