package br.com.novare.usecase.paginador

data class PaginadorOutputData(
    val limite: Int,
    val pagina: Long,
    val total: Long,
    val resultado: List<Any>
)
