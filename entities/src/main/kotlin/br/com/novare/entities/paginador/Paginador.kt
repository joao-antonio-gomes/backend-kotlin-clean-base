package br.com.novare.entities.paginador

class Paginador(
    val limite: Int,
    val pagina: Long
) {
    init {
        validaPaginador()
    }

    private fun validaPaginador() {
        if (limite < 0) {
            throw PaginadorInvalidoException("Limit deve ser maior ou igual a zero")
        }
        if (pagina < 0) {
            throw PaginadorInvalidoException("Offset deve ser maior ou igual a zero")
        }
        if (limite > 100) {
            throw PaginadorInvalidoException("Limit deve ser menor ou igual a 100")
        }
    }
}
