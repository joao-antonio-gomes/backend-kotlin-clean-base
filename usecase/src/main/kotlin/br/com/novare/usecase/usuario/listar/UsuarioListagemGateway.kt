package br.com.novare.usecase.usuario.listar

import br.com.novare.entities.paginador.Paginador
import br.com.novare.usecase.paginador.PaginadorOutputData
import br.com.novare.usecase.permissao.PermissaoOutputData

interface UsuarioListagemGateway {

    fun listar(paginador: Paginador): PaginadorOutputData
    fun findById(idUsuario: Long): UsuarioListagemOutputData?
    fun findPermissoesUsuario(idUsuario: Long): Set<PermissaoOutputData>
}
