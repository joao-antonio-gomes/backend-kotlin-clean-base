package br.com.novare.entities.usuario

import java.time.LocalDateTime

data class Usuario(
    val id: Long?,
    val nome: String,
    val email: String,
    val senha: String,
    val admin: Boolean,
    val status: UsuarioStatus,
    val dataCriacao: LocalDateTime,
    val avatarUrl: String?
) {
    private val senhaRegex = Regex("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%]).{8,20}\$")

    init {
        validaUsuario()
    }

    private fun validaUsuario() {
        if (nome.isBlank()) {
            throw UsuarioInvalidoException("Nome não pode ser vazio")
        }
        if (email.isBlank()) {
            throw UsuarioInvalidoException("Email não pode ser vazio")
        }
        if (senha.isBlank()) {
            throw UsuarioInvalidoException("Senha não pode ser vazia")
        }
        if (!senha.matches(senhaRegex)) {
            throw UsuarioInvalidoException("Senha deve conter ao menos 1 letra maiúscula, 1 letra minúscula, 1 número ou 1 caractere especial e possuir pelo menos 8 caracteres")
        }
    }
}
