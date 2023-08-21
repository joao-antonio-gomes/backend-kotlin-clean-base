package br.com.novare.adapters.perfilacesso

import br.com.novare.adapters.permissao.Permissao
import br.com.novare.adapters.usuario.Usuario
import jakarta.persistence.*

@Entity
data class PerfilAcesso(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(unique = true, nullable = false)
    var nome: String,

    @Column(unique = true, nullable = false)
    var descricao: String,

    @Column(unique = true, nullable = false)
    var ativo: Boolean = false,

    @ManyToMany(mappedBy = "perfisAcesso")
    var usuarios: Set<Usuario>? = null,

    @ManyToMany
    @JoinTable(
        name = "perfil_acesso_permissao",
        joinColumns = [JoinColumn(name = "perfil_acesso_id")],
        inverseJoinColumns = [JoinColumn(name = "permissao_id")]
    )
    var permissoes: Set<Permissao>? = null,
)
