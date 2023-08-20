package br.com.novare.entities.usuario

import br.com.novare.entities.exception.BusinessException

class UsuarioInvalidoException(
    override val message: String,
    override val status: Int = 400
) : BusinessException(message, status) {
}
