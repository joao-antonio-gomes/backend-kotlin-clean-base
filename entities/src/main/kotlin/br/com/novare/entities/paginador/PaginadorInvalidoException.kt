package br.com.novare.entities.paginador

class PaginadorInvalidoException(
    override val message: String
) : RuntimeException() {
}
