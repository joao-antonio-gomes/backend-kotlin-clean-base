package br.com.novare.entities.paginador

import br.com.novare.entities.exception.BusinessException

class PaginadorInvalidoException(
    override val message: String,
    override val status: Int = 400
) : BusinessException(message, status) {
}
