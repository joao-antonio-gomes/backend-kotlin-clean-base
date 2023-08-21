package br.com.novare.usecase.usuario.exception

import br.com.novare.entities.exception.BusinessException

class UsuarioJaExisteComEmailException(
    val email: String,
    override val status: Int = 400,
    override val message: String = "Usuário já existe com o email $email"
) : BusinessException(message, status) {

}
