package br.com.novare.usecase.usuario.cadastrar

import br.com.novare.entities.usuario.UsuarioEntity

interface UsuarioCadastroGateway {
    fun existeUsuarioComEmail(email: String): Boolean
    fun cadastrar(usuario: UsuarioEntity): Long
}
