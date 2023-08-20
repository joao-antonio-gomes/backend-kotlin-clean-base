package br.com.novare.adapters.usuario

import br.com.novare.entities.paginador.Paginador
import br.com.novare.entities.usuario.Usuario
import br.com.novare.entities.usuario.UsuarioStatus
import br.com.novare.usecase.paginador.PaginadorOutputData
import br.com.novare.usecase.usuario.cadastrar.UsuarioCadastroGateway
import br.com.novare.usecase.usuario.listar.UsuarioListagemGateway
import br.com.novare.usecase.usuario.listar.UsuarioListagemOutputData
import org.springframework.context.annotation.Primary
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component

@Component
@Primary
class JpaUsuarioAdapter(val jpaUsuarioRepository: JpaUsuarioRepository) : UsuarioListagemGateway,
    UsuarioCadastroGateway {

    override fun listar(paginador: Paginador): PaginadorOutputData {
        val pageable = Pageable.ofSize(paginador.limite).withPage(paginador.pagina.toInt())
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
            limite = paginador.limite,
            pagina = paginador.pagina,
            total = usuariosPaginados.totalElements,
            resultado = usuarios
        )
    }

    override fun existeUsuarioComEmail(email: String): Boolean {
        return jpaUsuarioRepository.existsByEmail(email)
    }

    override fun cadastrar(usuario: Usuario): Long {
        val usuarioData = UsuarioData(
            nome = usuario.nome,
            email = usuario.email,
            senha = usuario.senha,
            admin = usuario.admin,
            avatarUrl = usuario.avatarUrl,
            status = usuario.status
        )

        return jpaUsuarioRepository.save(usuarioData).id!!
    }
}
