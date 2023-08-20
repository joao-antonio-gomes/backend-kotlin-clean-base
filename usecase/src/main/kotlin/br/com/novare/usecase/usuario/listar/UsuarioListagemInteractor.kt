package br.com.novare.usecase.usuario.listar

import br.com.novare.entities.paginador.PaginadorEntity
import br.com.novare.usecase.paginador.PaginadorOutputData

class UsuarioListagemInteractor(
    val gateway: UsuarioListagemGateway
) : UsuarioListagemBoundary {

    override fun listar(limite: Int, pagina: Long): PaginadorOutputData {
        val paginador = PaginadorEntity(limite, pagina)
        return gateway.listar(paginador)
    }
}
