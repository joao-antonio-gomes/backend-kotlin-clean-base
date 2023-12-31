package br.com.novare.adapters.permissao

import br.com.novare.adapters.perfilacesso.PerfilAcesso
import br.com.novare.usecase.permissao.PermissaoOutputData
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull

@Entity
data class Permissao(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(unique = true, nullable = false)
    var nome: @NotNull String,

    @Column(unique = true, nullable = false)
    var descricao: @NotNull String,

    var ativo: @NotNull Boolean = false,

    @ManyToMany(mappedBy = "permissoes")
    var perfisAcesso: Set<PerfilAcesso>? = null,
) {
    fun toPermissaoOutputData(): PermissaoOutputData {
        return PermissaoOutputData(
            id = this.id!!,
            nome = this.nome,
            descricao = this.descricao,
            ativo = this.ativo,
        )
    }
}
