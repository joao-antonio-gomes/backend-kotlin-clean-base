package br.com.novare.usecase.usuario.listar

data class UsuarioListagemOutputData(
    val id: Long,
    val nome: String,
    val email: String,
    val avatarUrl: String?,
    val ativo: Boolean
)
