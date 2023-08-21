package br.com.novare.usecase.usuario.listar

import br.com.novare.entities.paginador.Paginador
import br.com.novare.usecase.paginador.PaginadorOutputData
import br.com.novare.usecase.usuario.exception.UsuarioNaoEncontradoException

class UsuarioListagemInteractor(
    val gateway: UsuarioListagemGateway
) : UsuarioListagemBoundary {

    override fun listar(limite: Int, pagina: Long): PaginadorOutputData {
        val paginador = Paginador(limite, pagina)
        return gateway.listar(paginador)
    }

    override fun possuiPermissao(idUsuario: Long, idPermissao: Long): Any {
        val usuario =
            gateway.findById(idUsuario) ?: throw UsuarioNaoEncontradoException(idUsuario)

        if (usuario.admin) {
            return true
        }

        val permissoesUsuario = gateway.findPermissoesUsuario(idUsuario)
        return permissoesUsuario.any { it.id == idPermissao }
    }
}
