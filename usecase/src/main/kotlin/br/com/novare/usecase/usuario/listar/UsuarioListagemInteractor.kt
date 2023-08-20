package br.com.novare.usecase.usuario.listar

import br.com.novare.entities.paginador.Paginador
import br.com.novare.usecase.paginador.PaginadorOutputData

class UsuarioListagemInteractor(
    val gateway: UsuarioListagemGateway
) : UsuarioListagemBoundary {

    override fun listar(limite: Int, pagina: Long): PaginadorOutputData {
        val paginador = Paginador(limite, pagina)
        return gateway.listar(paginador)
    }
}
