package br.com.novare.usecase.usuario.listar

import br.com.novare.usecase.paginador.PaginadorOutputData

interface UsuarioListagemBoundary {
    fun listar(limite: Int, pagina: Long): PaginadorOutputData
    fun possuiPermissao(idUsuario: Long, idPermissao: Long): Any
}
