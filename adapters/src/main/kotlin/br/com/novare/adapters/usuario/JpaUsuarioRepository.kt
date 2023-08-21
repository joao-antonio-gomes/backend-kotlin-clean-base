package br.com.novare.adapters.usuario

import br.com.novare.adapters.permissao.Permissao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface JpaUsuarioRepository : JpaRepository<Usuario, Long> {
    fun existsByEmail(email: String): Boolean

    @Query("SELECT perm FROM Usuario u JOIN u.perfisAcesso pA JOIN pA.permissoes perm WHERE u.id = :idUsuario")
    fun findPermissoesUsuario(idUsuario: Long): Set<Permissao>
}
