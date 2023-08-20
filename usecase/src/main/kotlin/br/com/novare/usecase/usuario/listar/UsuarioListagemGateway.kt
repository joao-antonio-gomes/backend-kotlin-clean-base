package br.com.novare.usecase.usuario.listar

import br.com.novare.entities.paginador.Paginador
import br.com.novare.usecase.paginador.PaginadorOutputData

interface UsuarioListagemGateway {

    fun listar(paginador: Paginador): PaginadorOutputData
}
