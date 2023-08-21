package br.com.novare.entities.usuario

interface UsuarioFactory {
    fun criaUsuario(
        nome: String,
        email: String,
        senha: String,
        admin: Boolean,
        avatarUrl: String?
    ): UsuarioEntity
}
