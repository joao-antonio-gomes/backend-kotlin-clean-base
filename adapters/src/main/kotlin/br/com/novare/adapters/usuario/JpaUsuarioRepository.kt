package br.com.novare.adapters.usuario

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JpaUsuarioRepository : JpaRepository<UsuarioData, Long> {
}
