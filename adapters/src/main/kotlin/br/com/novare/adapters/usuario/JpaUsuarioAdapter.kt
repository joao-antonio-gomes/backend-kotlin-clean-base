package br.com.novare.adapters.usuario

import br.com.novare.entities.paginador.Paginador
import br.com.novare.entities.usuario.UsuarioEntity
import br.com.novare.usecase.paginador.PaginadorOutputData
import br.com.novare.usecase.permissao.PermissaoOutputData
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
            usuario.toUsuarioListagemOutputData()
        }

        return PaginadorOutputData(
            limite = paginador.limite,
            pagina = paginador.pagina,
            total = usuariosPaginados.totalElements,
            resultado = usuarios
        )
    }

    override fun findById(idUsuario: Long): UsuarioListagemOutputData? {
        val usuarioData = jpaUsuarioRepository.findById(idUsuario)
        return usuarioData.map { usuario ->
            usuario.toUsuarioListagemOutputData()
        }.orElse(null)
    }

    override fun findPermissoesUsuario(idUsuario: Long): Set<PermissaoOutputData> {
        val permissoes = jpaUsuarioRepository.findPermissoesUsuario(idUsuario)
        return permissoes.map { permissao ->
            permissao.toPermissaoOutputData()
        }.toSet()
    }

    override fun existeUsuarioComEmail(email: String): Boolean {
        return jpaUsuarioRepository.existsByEmail(email)
    }

    override fun cadastrar(usuario: UsuarioEntity): Long {
        val usuarioData = Usuario(
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
