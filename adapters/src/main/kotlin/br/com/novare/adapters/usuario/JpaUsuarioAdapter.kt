package br.com.novare.adapters.usuario

import br.com.novare.entities.paginador.Paginador
import br.com.novare.usecase.paginador.PaginadorOutputData
import br.com.novare.usecase.usuario.listar.UsuarioListagemGateway
import br.com.novare.usecase.usuario.listar.UsuarioListagemOutputData
import org.springframework.context.annotation.Primary
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component

@Component
@Primary
class JpaUsuarioAdapter(val jpaUsuarioRepository: JpaUsuarioRepository) : UsuarioListagemGateway {
    override fun listar(paginador: Paginador): PaginadorOutputData {
        val pageable = Pageable.ofSize(paginador.getLimite()).withPage(paginador.getPagina().toInt())
        val usuariosPaginados = jpaUsuarioRepository.findAll(pageable)

        val usuarios = usuariosPaginados.content.map { usuario ->
            UsuarioListagemOutputData(
                id = usuario.id!!,
                nome = usuario.nome,
                email = usuario.email,
                avatarUrl = usuario.avatarUrl,
                ativo = usuario.status == UsuarioStatus.ATIVO
            )
        }

        return PaginadorOutputData(
            limite = paginador.getLimite(),
            pagina = paginador.getPagina(),
            total = usuariosPaginados.totalElements,
            resultado = usuarios
        )
    }
}
