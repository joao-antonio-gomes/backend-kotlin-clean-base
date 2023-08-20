package br.com.novare.usecase.usuario.cadastrar

data class UsuarioCadastroInputData(
    val nome: String,
    val email: String,
    val senha: String,
    val admin: Boolean,
    val avatarUrl: String?,
)
