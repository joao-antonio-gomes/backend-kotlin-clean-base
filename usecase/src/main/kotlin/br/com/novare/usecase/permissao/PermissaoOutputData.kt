package br.com.novare.usecase.permissao

data class PermissaoOutputData(
    val id: Long,
    val nome: String,
    val descricao: String,
    val ativo: Boolean,
)
