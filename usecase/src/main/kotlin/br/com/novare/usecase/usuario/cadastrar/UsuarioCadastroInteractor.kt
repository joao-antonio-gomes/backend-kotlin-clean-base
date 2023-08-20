package br.com.novare.usecase.usuario.cadastrar

import br.com.novare.entities.usuario.UsuarioFactory

class UsuarioCadastroInteractor(
    val gateway: UsuarioCadastroGateway,
    val factory: UsuarioFactory
) : UsuarioCadastroBoundary {

    override fun cadastrar(usuario: UsuarioCadastroInputData): Long {
        val usuario = factory.criaUsuario(usuario.nome, usuario.email, usuario.senha, usuario.admin, usuario.avatarUrl)

        if (gateway.existeUsuarioComEmail(usuario.email)) {
            throw UsuarioJaExisteComEmailException(usuario.email)
        }

        return gateway.cadastrar(usuario)
    }
}
