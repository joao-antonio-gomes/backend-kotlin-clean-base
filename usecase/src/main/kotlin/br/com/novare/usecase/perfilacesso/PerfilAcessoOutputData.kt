package br.com.novare.usecase.perfilacesso

data class PerfilAcessoOutputData(
    val id: Long,
    val nome: String,
    val descricao: String,
    val ativo: Boolean,
)
