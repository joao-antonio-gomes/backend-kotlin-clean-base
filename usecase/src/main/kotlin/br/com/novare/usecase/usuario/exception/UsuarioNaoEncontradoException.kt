package br.com.novare.usecase.usuario.exception

import br.com.novare.entities.exception.BusinessException

class UsuarioNaoEncontradoException(
    val id: Long,
    override val status: Int = 404,
    override val message: String = "Usuário com id $id não encontrado"
) : BusinessException(message, status) {

}
