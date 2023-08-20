package br.com.novare.adapters.usuario

import br.com.novare.adapters.perfilacesso.PerfilAcesso
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import java.time.LocalDateTime

@Entity
@Table(name = "usuario")
data class UsuarioData(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false)
    var nome: @NotNull String,

    @Column(unique = true, nullable = false)
    var email: @NotNull String,

    @Column(nullable = false)
    var senha: @NotNull String,

    var avatarUrl: @NotNull String? = null,

    @Column(nullable = false)
    var dataCadastro: @NotNull LocalDateTime? = LocalDateTime.now(),

    @Column(nullable = false)
    var admin: @NotNull Boolean = false,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var status: UsuarioStatus,

    @JvmField
    @ManyToMany
    @JoinTable(
        name = "usuario_perfil_acesso",
        joinColumns = [JoinColumn(name = "usuario_id")],
        inverseJoinColumns = [JoinColumn(name = "perfil_acesso_id")]
    )
    var perfisAcesso: Set<PerfilAcesso>? = null,
)
