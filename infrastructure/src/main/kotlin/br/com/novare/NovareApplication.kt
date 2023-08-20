package br.com.novare

import br.com.novare.adapters.usuario.JpaUsuarioAdapter
import br.com.novare.usecase.usuario.listar.UsuarioListagemBoundary
import br.com.novare.usecase.usuario.listar.UsuarioListagemInteractor
import lombok.extern.slf4j.Slf4j
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Bean
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Slf4j
@SpringBootApplication
@EnableJpaRepositories(basePackages = ["br.com.novare.adapters.*"])
@EntityScan("br.com.novare.adapters.*")
class NovareApplication {

    @Bean
    fun usuarioListagemBoundary(jpaUsuarioAdapter: JpaUsuarioAdapter): UsuarioListagemBoundary {
        return UsuarioListagemInteractor(jpaUsuarioAdapter)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("Inicializando aplicação...")
            SpringApplication.run(NovareApplication::class.java, *args)
        }
    }
}
