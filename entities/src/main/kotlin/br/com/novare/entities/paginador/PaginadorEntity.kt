package br.com.novare.entities.paginador

class PaginadorEntity(
    private val limite: Int,
    private val pagina: Long
) : Paginador {
    init {
        validaPaginador()
    }

    override fun validaPaginador() {
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

    override fun getLimite(): Int {
        return limite
    }

    override fun getPagina(): Long {
        return pagina
    }
}
