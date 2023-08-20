package br.com.novare.entities.usuario

import java.time.LocalDateTime

class UsuarioFactoryImpl : UsuarioFactory {
    override fun criaUsuario(
        nome: String,
        email: String,
        senha: String,
        admin: Boolean,
        avatarUrl: String?
    ): Usuario {
        return Usuario(
            id = null,
            nome = nome,
            email = email,
            senha = senha,
            admin = admin,
            status = UsuarioStatus.ATIVO,
            dataCriacao = LocalDateTime.now(),
            avatarUrl = avatarUrl
        )
    }
}
